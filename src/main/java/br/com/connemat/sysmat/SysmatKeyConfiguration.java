package br.com.connemat.sysmat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import br.com.connemat.model.api.ResourceUriRole;
import br.com.connemat.service.impl.SysmatKeyCloakUriRoleServiceImpl;
import br.com.connemat.spring.data.repository.AuthServerConfigRepository;
import br.com.connemat.spring.security.ConnematAccessDecisionManager;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Configuration
@Profile(value = "keycloak")
public class SysmatKeyConfiguration  extends WebSecurityConfigurerAdapter {

	private static final String WORKSPACE_ADMIN_GROUP = "/WORKSPACE_ADMIN_GROUP";

	//TODO: Levar para o banco de dados essa configuração ou resources properties.	
	//TODO: configurar um bean acessando o wellknow url's 
	//							  http://192.168.0.81:8180/auth/realms/connemat/protocol/openid-connect/token
								//http://192.168.0.81:8180/auth/realms/connemat/protocol/openid-connect/certs	
	
	@Value("${jwkCertsUri}")
	private String jwkCertsUri = "http://localhost/auth/realms/connemat/protocol/openid-connect/certs";	

	private final String ADMIN_ROLE = "sysmat_admin";
	
	private final String REALM_ADMIN_ROLE = "admin";
	
	private Logger log = LoggerFactory.getLogger(SysmatKeyConfiguration.class);
	
	@Autowired 
	@Qualifier("JacksonJsonParser") 
	private JsonParser jsonParser; 
	
	@Autowired
	private AuthServerConfigRepository authServerConfigRepository;
	
	@Autowired
	private SysmatKeyCloakUriRoleServiceImpl sysmatKeyCloakUriRoleService;

	@Bean
	public GrantedAuthoritiesMapper grantedAuthoritiesMapper() {
		SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
		mapper.setConvertToUpperCase(true);
		return mapper;
	}

	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		HttpSecurity http1 = http
							.csrf()
							.disable()
							.sessionManagement()
							.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and();
		configureResourceUriRoleAntMatchers(http1.authorizeRequests())
		.antMatchers("/sysmat_auth/**").authenticated()
		.anyRequest().permitAll()
		.accessDecisionManager(ConnematAccessDecisionManager.forAffirmativeBased())
		.and()
		.oauth2ResourceServer(
                oauth2ResourceServer -> oauth2ResourceServer.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                ));
	}

	private AbstractRequestMatcherRegistry<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl> configureResourceUriRoleAntMatchers(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests)throws Exception {
		List<ResourceUriRole> roles = sysmatKeyCloakUriRoleService.getAllValidSysmatClientResourceAssociatedUriRoles();
		
		AbstractRequestMatcherRegistry<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl>
		requestRegistryMatcher = authorizeRequests;
		
		for (ResourceUriRole role : roles) {
			for (String uriStr : role.getUris()) {
				requestRegistryMatcher = verifyAnyGroupRole(authorizeRequests ,  role , uriStr);
			}
		}
		return requestRegistryMatcher;
	}


	private AbstractRequestMatcherRegistry<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl>
				verifyAnyGroupRole
							(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry ar,
										ResourceUriRole role, String uriStr) throws Exception{
		AbstractRequestMatcherRegistry<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl> 
		authorizedUrl = ar; 
		HttpMethod  method;
		List<String> roles = role.getRoles();
		
		System.err.print("URI_STRING \t");
		System.err.println(uriStr);
		
		for (String roleStr  : roles ) {
			 if(roleStr.contains(":view")){
			     method = HttpMethod.GET;
			     authorizedUrl = authorizedUrl
		     						.antMatchers(method , uriStr).hasAnyRole(ADMIN_ROLE ,  roleStr);
			 }
			 if(roleStr.contains(":add")){
			     method = HttpMethod.POST;
			     authorizedUrl = authorizedUrl
		     						.antMatchers(method , uriStr).hasAnyRole(ADMIN_ROLE , roleStr);
			 }
			 if(roleStr.contains(":edit")){
			     method = HttpMethod.PUT;
			     authorizedUrl = authorizedUrl
		     						.antMatchers(method , uriStr).hasAnyRole(ADMIN_ROLE , roleStr);
			 }
			 if(roleStr.contains(":delete")){
			     method = HttpMethod.DELETE;
			     authorizedUrl = authorizedUrl
			    		 			.antMatchers(method , uriStr).hasAnyRole(ADMIN_ROLE ,  roleStr);
			 }
			 if(ADMIN_ROLE.equals(roleStr)){
			     authorizedUrl = authorizedUrl
			    		 			.antMatchers(uriStr).hasAnyRole(ADMIN_ROLE , roleStr);
			 }
			 if(isSysmatUserRole(roleStr)) {
			     authorizedUrl = authorizedUrl
	    		 					.antMatchers(uriStr).hasAnyRole(ADMIN_ROLE , roleStr);
			 }
		}
		return authorizedUrl;
	}

	private boolean isSysmatUserRole(String roleStr) {
		return roleStr.equals("sysmat_users");
	}

	private boolean isAdministrativeRole(String roleStr) {
		return roleStr.equals(ADMIN_ROLE);
	}


	  private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
	        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
	        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
	        return jwtConverter;
	    }
	  

	@Bean JwtDecoder jwtDecoder() { return
			NimbusJwtDecoder.withJwkSetUri(this.jwkCertsUri).build(); 
	}
	
	public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
		private static final String REALM_ACCESS = "realm_access";
		private static final String GROUPS = "groups_member";
		private static final String RESOURCE_ACCESS = "resource_access";
	   
		@Override
	    public Collection<GrantedAuthority> convert(Jwt jwt) {
	    	
	        final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get(REALM_ACCESS);
	        
	        final Map<String,JSONObject> resourceAccess = (Map<String, JSONObject>) jwt.getClaims().get(RESOURCE_ACCESS);
	        
	        System.err.println(jwt.getTokenValue());
	        List<GrantedAuthority> realmRoles = new ArrayList<>();
	        
	        List<JSONArray> realmRoleArray = realmAccess
		        	.keySet()
		        	.stream()
		        	.filter(k -> "roles".equals(k))
		        	.map(key -> {
		        			return (JSONArray) realmAccess.get(key);
		        			})
		        	.collect(Collectors.toList());
	        
	        List<JSONArray> roleArray = resourceAccess
	        	.values()
	        	.stream()
	        	.map(job -> {
	        			return (JSONArray) job.get("roles");
	        			})
	        	.collect(Collectors.toList());
	        
	        roleArray
	        .stream()
	        .forEach(a -> a.forEach(roleName -> {
	        	realmRoles.add( new SimpleGrantedAuthority("ROLE_" + roleName));
	        }));
	        
	        realmRoleArray
	        .stream()
	        .forEach(a -> a.forEach(roleName -> {
	        	realmRoles.add( new SimpleGrantedAuthority("ROLE_" + roleName));
	        }));
	        
	         return realmRoles;
	    }
	}

}
