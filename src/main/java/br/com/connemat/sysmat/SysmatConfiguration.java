package br.com.connemat.sysmat;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.Validator;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("br.com.connemat , org.keycloak.models")
@EnableConfigurationProperties
@EnableJpaRepositories(
		basePackages = 
	{"br.com.connemat.spring.data.repository"}
					, transactionManagerRef = "connemat-tm")
@EnableAutoConfiguration(exclude = 
						{DataSourceAutoConfiguration.class, 
						DataSourceHealthContributorAutoConfiguration.class, 
						DataSourceTransactionManagerAutoConfiguration.class, 
						HibernateJpaAutoConfiguration.class})
@EnableWebMvc
public class SysmatConfiguration  implements WebMvcConfigurer {

	
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter(objectMapper()));
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new BufferedImageHttpMessageConverter());
	}
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		DateTimeFormatter dtf =  DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(dtf);
	    JavaTimeModule module = new JavaTimeModule();
	    Jdk8Module jdk8Module = new Jdk8Module();
	    Hibernate5Module hibModule = new Hibernate5Module();
	    hibModule.enable(Feature.REPLACE_PERSISTENT_COLLECTIONS);
	    hibModule.enable(Feature.WRITE_MISSING_ENTITIES_AS_NULL);
	    hibModule.enable(Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER);
	    module.addSerializer(serializer);
	    return new ObjectMapper()
	      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
	      .registerModule(module)
	      .registerModule(hibModule)
	      .registerModule(jdk8Module);
	}
	
	@Bean
	@Primary
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter
				(@Autowired ObjectMapper mapper) {
	    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(mapper);
	    return jsonConverter;
	}
	
	@SuppressWarnings("unchecked")
	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		DateTimeFormatter dtf =  DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(dtf);
	    Jdk8Module jdk8Module = new Jdk8Module();
	    Hibernate5Module hibModule = new Hibernate5Module();
	    hibModule.enable(Feature.REPLACE_PERSISTENT_COLLECTIONS);
	    hibModule.enable(Feature.WRITE_MISSING_ENTITIES_AS_NULL);
	    hibModule.enable(Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER);
		JavaTimeModule timeModule = new JavaTimeModule();
		timeModule.addSerializer(serializer);
		return new Jackson2ObjectMapperBuilder()
					.modulesToInstall(Hibernate5Module.class , JavaTimeModule.class ,  Jdk8Module.class)
					.modules(timeModule,hibModule,jdk8Module);
	}

	@Bean
	@Qualifier(value = "JacksonJsonParser") 
	public JsonParser jsonParser(){
		return new JacksonJsonParser();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setUseIsoFormat(true);
		registrar.registerFormatters(registry);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	@Primary
	public LocalValidatorFactoryBean getLocalValidatorFactoryBean() { 
		LocalValidatorFactoryBean validatorFactoryBean =  new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource());
		return validatorFactoryBean;
	}

	@Bean
	@Primary
	public MethodValidationPostProcessor methodValidationPostProcessor(@Autowired Validator validator) {
		MethodValidationPostProcessor processor =  new MethodValidationPostProcessor();
		processor.setValidator(validator);
		processor.setProxyTargetClass(false);
		processor.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return processor;
	}

	@Bean
	@Primary
	@Qualifier(value="customjpaproperties")
	public Map<String, Object> customjpaproperties(){
		Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put(Environment.FORMAT_SQL, true);
        jpaPropertiesMap.put(Environment.SHOW_SQL, true);
        jpaPropertiesMap.put("hibernate.globally_quoted_identifiers", true);
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaPropertiesMap.put("hibernate.transaction.auto_close_session" , true);
		jpaPropertiesMap.put("hibernate.current_session_context_class" , "thread" );
		jpaPropertiesMap.put("hibermate.hbm2ddl.auto" , "none" );
		return jpaPropertiesMap;
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}

	@Bean("keycloak-datasource")
	public DataSource keyCloakDataSource(@Autowired @Qualifier("keycloak-config-datasource") HikariConfig hikariConfig) { 
		return new HikariDataSource(hikariConfig);
	}

	@Bean
	@Primary
	@Qualifier(value="connemat-em")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put(Environment.FORMAT_SQL, true);
        jpaPropertiesMap.put(Environment.SHOW_SQL, true);
        jpaPropertiesMap.put("hibernate.globally_quoted_identifiers", true);
        jpaPropertiesMap.put("hibernate.transaction.flush_before_completion"  , true);
        jpaPropertiesMap.put("hibernate.transaction.auto_close_session" , true);
		jpaPropertiesMap.put("hibernate.current_session_context_class" , "thread" );
		jpaPropertiesMap.put("hibernate.enable_lazy_load_no_trans" , true);
		jpaPropertiesMap.put("hibermate.hbm2ddl.auto" , "none" );
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(new String []{"br.com.connemat.model.entity"});
		factory.setPersistenceUnitName("connemat");
		factory.setJpaPropertyMap(customjpaproperties());
		factory.setDataSource(dataSource);
		return factory;
	}

	@Bean("connemat-tm")
	@Qualifier(value="connemat-tm")
	@Primary
	public PlatformTransactionManager transactionManager(
			@Autowired EntityManagerFactory entityManagerFactory,
			@Autowired DataSource dataSource) { 
		JpaTransactionManager txManager = new JpaTransactionManager(entityManagerFactory);
		txManager.setPersistenceUnitName("connemat");
		txManager.setDataSource(dataSource);
		txManager.setNestedTransactionAllowed(true);
		return txManager; 
	}

}