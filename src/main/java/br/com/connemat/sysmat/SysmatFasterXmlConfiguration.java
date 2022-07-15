package br.com.connemat.sysmat;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Deprecated
//@Configuration
public class SysmatFasterXmlConfiguration {
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		DateTimeFormatter dtf =  DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(dtf);
	    JavaTimeModule module = new JavaTimeModule();
	    Hibernate5Module hibModule = new Hibernate5Module();
	    hibModule.enable(Feature.REPLACE_PERSISTENT_COLLECTIONS);
	    hibModule.enable(Feature.WRITE_MISSING_ENTITIES_AS_NULL);
	    hibModule.enable(Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER);
	    module.addSerializer(serializer);
	    return new ObjectMapper()
	      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
	      .registerModule(module)
	      .registerModule(hibModule);
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
	    Hibernate5Module hibModule = new Hibernate5Module();
	    hibModule.enable(Feature.REPLACE_PERSISTENT_COLLECTIONS);
	    hibModule.enable(Feature.WRITE_MISSING_ENTITIES_AS_NULL);
	    hibModule.enable(Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER);
		JavaTimeModule timeModule = new JavaTimeModule();
		timeModule.addSerializer(serializer);
		return new Jackson2ObjectMapperBuilder()
					.modulesToInstall(Hibernate5Module.class , JavaTimeModule.class)
					.modules(timeModule,hibModule);
	}

	@Bean
	@Qualifier(value = "JacksonJsonParser") 
	public JsonParser jsonParser(){
		return new JacksonJsonParser();
	}

}
