package br.com.connemat.sysmat;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import br.com.connemat.spring.data.repository.AuthServerConfigRepository;


@KeycloakConfiguration
public class SysmatKeyConfiguration extends KeycloakWebSecurityConfigurerAdapter {

	//TODO: Levar para o banco de dados essa configuração ou resources properties.	
	//TODO: configurar um bean acessando o wellknow url's 	
	private String jwkCertsUri = "http://localhost:4200/auth/realms/connemat/protocol/openid-connect/certs";	

	private Logger log = LoggerFactory.getLogger(SysmatKeyConfiguration.class);

	@Autowired
	private AuthServerConfigRepository authServerConfigRepository;

	@Bean
	public GrantedAuthoritiesMapper grantedAuthoritiesMapper() {
		SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
		mapper.setConvertToUpperCase(true);
		return mapper;
	}

	@Override
	protected KeycloakAuthenticationProvider keycloakAuthenticationProvider() {
		final KeycloakAuthenticationProvider provider = super.keycloakAuthenticationProvider();
		provider.setGrantedAuthoritiesMapper(grantedAuthoritiesMapper());
		return provider;
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		// return new NullAuthenticatedSessionStrategy();
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	//TODO:verificar como parametrizar as URL's para uma futura configuração de segurança.
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		//  Exemplo de chamada do repositorio durante a subida da configuração.	  
		//	List<AuthServerConfig> configs = authServerConfigRepository.findAll();  
		//	log.debug ("{0}", configs.toString());
		super.configure(http);
		http
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("admin")
		.antMatchers("/item/**").hasRole("user")
		.antMatchers("/workspaces/**").hasRole("user")
//		.antMatchers("/workspaces/*/*").hasRole("user")
		.antMatchers("/config/**").permitAll()
		.anyRequest().permitAll()
		.and().oauth2ResourceServer().jwt();
	}

	@Bean
	KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

	@Bean
	public FilterRegistrationBean keycloakAuthenticationProcessingFilterRegistrationBean(
			final KeycloakAuthenticationProcessingFilter filter) {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
		registrationBean.setEnabled(false);
		return registrationBean;
	}

	
	@Bean JwtDecoder jwtDecoder() { return
			NimbusJwtDecoder.withJwkSetUri(this.jwkCertsUri).build(); 
	}
	

}
