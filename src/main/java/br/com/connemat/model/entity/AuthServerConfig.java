package br.com.connemat.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Deprecated
@Entity
@Table(name="AuthServerConfig")
public class AuthServerConfig extends BaseConfig {

	private String baseLogonUrl; 
	
	private String introspectUrl; 
	
	private String tokenUrl; 
	
	private String clientId; 
	
	private String clientSecret;

	public AuthServerConfig() {
		super();
	}

	public String getBaseLogonUrl() {
		return baseLogonUrl;
	}

	public void setBaseLogonUrl(String baseLogonUrl) {
		this.baseLogonUrl = baseLogonUrl;
	}

	public String getIntrospectUrl() {
		return introspectUrl;
	}

	public void setIntrospectUrl(String introspectUrl) {
		this.introspectUrl = introspectUrl;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	} 
	
}
