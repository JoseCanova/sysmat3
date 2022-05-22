package br.com.connemat.sysmat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.InstanceDataSourceConfigBaseService;
import br.com.connemat.model.entity.DataSourceConfig;
import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.InstanceDataSourceConfig;
import br.com.connemat.service.config.DataSourceConfigServiceImpl;
import br.com.connemat.service.datasource.BaseDataSourceConfiguration;
import br.com.connemat.service.datasource.DataSourceConfigConverter;
import br.com.connemat.spring.datasource.TenantContext;

@Configuration
@EnableJpaRepositories(
		basePackages = 
			{"br.com.connemat.sysmat.repository"},
			entityManagerFactoryRef = "tenantEntityManagerFactory", 
			transactionManagerRef = "tenant-tm")
public class SysmatMultiTenantConfiguration {

    @Autowired
    private DataSourceConfigServiceImpl service;
    
//    @Autowired
    private InstanceDataSourceConfigBaseService instanceDataSourceService;
    
    @Bean("tenantRoutingDataSource")
    @Qualifier(value="tenantRoutingDataSource")
    @DependsOn("connemat-tm")
    public DataSource tenantRoutingDataSource() {
//    	TenantRoutingDatasource dataSource = new TenantRoutingDatasource();
//    	dataSource.setTargetDataSources(getNewAll());
    	return DataSourceBuilder.create().build();
//    	return dataSource;
    }
    
    @Bean
    @Qualifier(value="sysmatdefaultdatasource")
    @ConfigurationProperties("sysmatdefault.datasource")
    public DataSource sysmatDefaultDataSource()
    {
    	return DataSourceBuilder.create().build();
    }   
    
    @Transactional("connemat-tm")
    private Map<Object, Object> getNewAll() {
        Iterable<InstanceDataSourceConfig> configList = instanceDataSourceService.findAll();
        Map<Object, Object> result = new HashMap<>();
        for (InstanceDataSourceConfig config : configList) {
        	Instance instance = config.getInstance();
            DataSource dataSource = createDataSource(config);
            result.put(instance.getCode(), dataSource);
        }
        result.put(TenantContext.DEFAULT_TENANT_ID, sysmatDefaultDataSource());
        return result;
    }
    
    private DataSource createDataSource(InstanceDataSourceConfig config) {
    	BaseDataSourceConfiguration dsc = DataSourceConfigConverter.processConfig(config);
    	return DataSourceBuilder
    		.create()
    		.driverClassName("org.postgresql.Driver")
    		.username(dsc.getUserName())
    		.password(dsc.getPassword())
    		.url(dsc.getUrl()).build();
	}

	@Transactional("connemat-tm")
    private Map<Object, Object> getAll() {
        List<DataSourceConfig> configList = service.findAll();
        Map<Object, Object> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = createDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        result.put(TenantContext.DEFAULT_TENANT_ID, sysmatDefaultDataSource());
        return result;
    }
    
    @Transactional("connemat-tm")
    private DataSource createDataSource(String name) {
        DataSourceConfig config = service.findByName(name);
        if (config != null) {
            DataSourceBuilder<?> factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            return ds;
        }
        return null;
    }
    
    @Transactional("connemat-tm")
    @DependsOn("connemat-tm")
    @Bean("tenantEntityManagerFactory")
	@Qualifier(value="tenantEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
    ) {
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setGenerateDdl(false);
        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put(Environment.FORMAT_SQL, true);
        jpaPropertiesMap.put(Environment.SHOW_SQL, true);
        jpaPropertiesMap.put("hibernate.globally_quoted_identifiers", false);
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaPropertiesMap.put("hibernate.transaction.auto_close_session" , true);
		jpaPropertiesMap.put("hibernate.current_session_context_class" , "thread" );
		jpaPropertiesMap.put("hibernate.enable_lazy_load_no_trans" , true);
		jpaPropertiesMap.put("hibermate.hbm2ddl.auto" , "none" );
		jpaPropertiesMap.put("hibernate.default_schema", "sysmat3");
		jpaPropertiesMap.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
		jpaPropertiesMap.put("javax.persistence.schema-generation.scripts.create-target", "c:\\softwares\\connemat\\create-sysmat.sql");
		jpaPropertiesMap.put("javax.persistence.schema-generation.scripts.drop-target" , "c:\\softwares\\connemat\\drop-sysmat.sql");
        
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(tenantRoutingDataSource());
        em.setPackagesToScan(new String []{"br.com.connemat.sysmat.model.entity"});
        em.setJpaVendorAdapter(adapter);
        em.setJpaPropertyMap(jpaPropertiesMap);
        em.setPersistenceUnitName("tenant-sysmat");
        return em;
    }
	
	@Bean("tenant-tm")
	@Qualifier(value="tenant-tm")
	public PlatformTransactionManager 
					tenantTransactionManager(@Autowired @Qualifier("tenantEntityManagerFactory") 
												EntityManagerFactory entityManagerFactory) { 
			JpaTransactionManager txManager = new JpaTransactionManager(entityManagerFactory);
//			txManager.setEntityManagerFactory(entityManagerFactory); 
			txManager.setDataSource(tenantRoutingDataSource());
			txManager.setNestedTransactionAllowed(true);
			txManager.setPersistenceUnitName("tenant-sysmat");
			return txManager; 
	}
	
}