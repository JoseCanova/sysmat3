package br.com.connemat.sysmat;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableConfigurationProperties
@EnableJpaRepositories(
			basePackages = 
				{"org.keycloak.models.repository"},
				transactionManagerRef ="keycloak-tm" ,
				entityManagerFactoryRef = "keyCloakEntityManagerFactory")
@Profile(value = "keycloak")
public class SysmatKeyCloakDataSourceConfiguration {

	@Autowired
	@Qualifier("customjpaproperties")
	private Map<String,Object> jpaPropertiesMap;
	
	public SysmatKeyCloakDataSourceConfiguration() {
	}
	
	@Bean
	@ConfigurationProperties(prefix = "keycloak-config.datasource")
	public Properties hirakiKeyCloakProperties() {
		return new Properties();
	} 
	
	@Bean("keycloak-config-datasource")
	@ConfigurationProperties(prefix = "keycloak-config.datasource")
	public HikariConfig hikariKeycloakConfig() {
		Properties theProperties = hirakiKeyCloakProperties() ;
		return new HikariConfig(theProperties);
	}
	
	@Bean("keycloak-datasource")
	public DataSource keyCloakDataSource(@Autowired @Qualifier("keycloak-config-datasource") HikariConfig hikariConfig) { 
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean("keyCloakEntityManagerFactory")
	@Qualifier(value="keyCloakEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean keycloakEntityManagerFactory(@Autowired @Qualifier("keycloak-datasource") DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(new String []{"org.keycloak.models.jpa.entities"});
		factory.setPersistenceUnitName("keycloak");
		factory.setDataSource(dataSource);
		factory.setJpaPropertyMap(jpaPropertiesMap);
		return factory;
	}
	
	@Bean("keycloak-tm")
	@Qualifier(value="keycloak-tm")
	public PlatformTransactionManager keyCloakTransactionManager(@Autowired @Qualifier("keyCloakEntityManagerFactory") EntityManagerFactory entityManagerFactory) { 
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory); 
		return txManager; 
	}
	

}
