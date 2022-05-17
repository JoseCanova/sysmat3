package br.com.connemat.sysmat;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.connemat.rest.model.KeyCloakConfiguration;
import br.com.connemat.rest.model.KeyCloakConfiguration.KeyCloakEndpoints;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SysmatSwaggerConfiguration {

	@Autowired KeyCloakConfiguration keyCloakConfiguration;
	
	@Autowired KeyCloakEndpoints keyCloakEndpoints;

	public SysmatSwaggerConfiguration() {
	}

	@Bean 
	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())   
          .build()
          .securityContexts(Arrays.asList(securityContext()));                                           
    }
	
	
	//TODO:ainda não está funcionando.
	private SecurityScheme securityScheme() {
	    GrantType grantType = new AuthorizationCodeGrantBuilder()
	        .tokenEndpoint(new TokenEndpoint("http://localhost:8180/auth/realms/connemat/protocol/openid-connect/token", "oauthtoken"))
	        .tokenRequestEndpoint(
	          new TokenRequestEndpoint("http://localhost:8180/auth/realms/connemat/protocol/openid-connect/token", keyCloakEndpoints.getResource(), keyCloakConfiguration.getCredentialsSecret().getSecret()))
	        .build();
	 
	    SecurityScheme oauth = new OAuthBuilder().name("sysmat")
	        .grantTypes(Arrays.asList(grantType))
	        .scopes(Arrays.asList(scopes()))
	        .build();
	    return oauth;
	}
	
	private AuthorizationScope[] scopes() {
	    AuthorizationScope[] scopes = { 
	      new AuthorizationScope("user", "for read operations"), 
	      new AuthorizationScope("sysmat_users", "for write operations"), 
	      new AuthorizationScope("admin", "Access foo API") };
	    return scopes;
	}
	
	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	      .securityReferences(
	        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
	      .forPaths(PathSelectors.regex("/foos.*"))
	      .build();
	}
	
	@Component
	public class ConnematSwaggerConfigurer implements WebMvcConfigurer{ 
		
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("swagger-ui.html")
		      .addResourceLocations("classpath:/META-INF/resources/");
		 
		    registry.addResourceHandler("/webjars/**")
		      .addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
		
	}
}
