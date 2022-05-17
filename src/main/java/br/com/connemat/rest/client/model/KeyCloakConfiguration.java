package br.com.connemat.rest.client.model;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeyCloakConfiguration {

	@NotEmpty
	private String realm; 
	
	@NotEmpty
	private String authServerUrl;
	
	@Autowired private CredentialsSecret credentialsSecret;
	
	@Autowired private KeyCloakEndpoints keyCloakEndpoints; 
	
	public KeyCloakConfiguration() {
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getAuthServerUrl() {
		return authServerUrl;
	}

	public void setAuthServerUrl(String authServerUrl) {
		this.authServerUrl = authServerUrl;
	}

	public CredentialsSecret getCredentialsSecret() {
		return credentialsSecret;
	}

	public void setCredentialsSecret(CredentialsSecret credentialsSecret) {
		this.credentialsSecret = credentialsSecret;
	}

	public KeyCloakEndpoints getKeyCloakEndpoints() {
		return keyCloakEndpoints;
	}

	public void setKeyCloakEndpoints(KeyCloakEndpoints keyCloakEndpoints) {
		this.keyCloakEndpoints = keyCloakEndpoints;
	}
	
	private StringBuilder withAuthUrl() { 
		return new StringBuilder().append(this.authServerUrl);
	}
	
	public String getTokenUrl() { 
		return withAuthUrl().append(this.getKeyCloakEndpoints().getTokenUrl()).toString();
	}
	
	public String getGroupUrl(boolean isBrief) { 
		String url = Optional
			.ofNullable(isBrief)
			.map(b ->{
				if (b == true) {
					return this.getKeyCloakEndpoints().getGroupUrl() ;
 				}else { 
 					return this.getKeyCloakEndpoints().getGroupUrl() + "?briefRepresentation=false";
 				}
			}).orElseThrow(RuntimeException::new);
		return withAuthUrl().append(url).toString();
	}
	
	public String getGroupUrl(boolean b, Integer start, Integer max) {
		StringBuffer sb = new StringBuffer(getGroupUrl(b));
		sb.append("&first=").append(Optional.ofNullable(start).orElse(0));
		sb.append("&max=").append(Optional.ofNullable(max).orElse(0));
		return sb.toString();
	}
	
	public String getGroupUrl(boolean b, Integer start, Integer max, String searchString) {
		StringBuffer sb = new StringBuffer(getGroupUrl(b,start,max));
		sb.append("&search=");
		sb.append(searchString);
		return sb.toString();
	}
	
	public String getUserUrl() { 
		return withAuthUrl().append(this.getKeyCloakEndpoints().getUserUrl()).toString();
	}

	@Component
	@ConfigurationProperties(prefix = "keycloak.credentials")
	public class CredentialsSecret { 
		
		@NotEmpty
		private String secret; 
		
		public CredentialsSecret() {}

		public String getSecret() {
			return secret;
		}

		public void setSecret(String secret) {
			this.secret = secret;
		}
	}
	
	@Component
	@ConfigurationProperties(prefix="keycloak-server-urls")
	public class KeyCloakEndpoints{ 
		
		@NotEmpty
		private String tokenUrl; 
		
		@NotEmpty
		private String groupUrl; 
		
		@NotEmpty
		private String userUrl; 
		
		@NotEmpty
		private String realmClientUrl;
		
		@NotEmpty private String logoutUrl;
		
		@NotEmpty
		private String resourceUrl; 
		
		@NotEmpty
		private String permissionsUrl;
		
		@NotEmpty 
		private String permissionUrl;
		
		@NotEmpty
		private String resource; 
		
		public KeyCloakEndpoints() {}

		public String getTokenUrl() {
			return tokenUrl;
		}

		public void setTokenUrl(String tokenUrl) {
			this.tokenUrl = tokenUrl;
		}

		public String getGroupUrl() {
			return groupUrl;
		}

		public void setGroupUrl(String groupUrl) {
			this.groupUrl = groupUrl;
		}

		public String getUserUrl() {
			return userUrl;
		}

		public void setUserUrl(String userUrl) {
			this.userUrl = userUrl;
		}

		public String getRealmClientUrl() {
			return realmClientUrl;
		}

		public void setRealmClientUrl(String realmClientUrl) {
			this.realmClientUrl = realmClientUrl;
		}

		public String getResourceUrl() {
			return resourceUrl;
		}

		public void setResourceUrl(String resourceUrl) {
			this.resourceUrl = resourceUrl;
		}

		public String getPermissionsUrl() {
			return permissionsUrl;
		}

		public void setPermissionsUrl(String permissionsUrl) {
			this.permissionsUrl = permissionsUrl;
		}

		public String getPermissionUrl() {
			return permissionUrl;
		}

		public void setPermissionUrl(String permissionUrl) {
			this.permissionUrl = permissionUrl;
		}

		public String getResource() {
			return resource;
		}

		public void setResource(String resource) {
			this.resource = resource;
		}

		public String getLogoutUrl() {
			return logoutUrl;
		}

		public void setLogoutUrl(String logoutUrl) {
			this.logoutUrl = logoutUrl;
		} 
		
		
	}

}

