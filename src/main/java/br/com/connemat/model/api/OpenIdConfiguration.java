package br.com.connemat.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenIdConfiguration {

	@JsonProperty(value = "issuer")
	private String issuer;
	
	@JsonProperty(value = "authorization_endpoint")
	private String authorizationEndpoint; 
	
	@JsonProperty(value="token_endpoint")
	private String tokenEndpoint; 
	
	@JsonProperty(value="introspection_endpoint")
	private String introspectionEndpoint; 
	
	@JsonProperty(value="userinfo_endpoint")
	private String userInfoEndpoint; 
	
	@JsonProperty(value="end_session_endpoint")
	private String endSessionEndpoint; 
	
	@JsonProperty(value="jwks_uri")
	private String jwksUri;
	
	@JsonProperty(value="check_session_iframe")
	private String checkSessionIframe; 
	
	
	public OpenIdConfiguration() {
	}


	public String getIssuer() {
		return issuer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}


	public String getAuthorizationEndpoint() {
		return authorizationEndpoint;
	}


	public void setAuthorizationEndpoint(String authorizationEndpoint) {
		this.authorizationEndpoint = authorizationEndpoint;
	}


	public String getTokenEndpoint() {
		return tokenEndpoint;
	}


	public void setTokenEndpoint(String tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
	}


	public String getIntrospectionEndpoint() {
		return introspectionEndpoint;
	}


	public void setIntrospectionEndpoint(String introspectionEndpoint) {
		this.introspectionEndpoint = introspectionEndpoint;
	}


	public String getUserInfoEndpoint() {
		return userInfoEndpoint;
	}


	public void setUserInfoEndpoint(String userInfoEndpoint) {
		this.userInfoEndpoint = userInfoEndpoint;
	}


	public String getEndSessionEndpoint() {
		return endSessionEndpoint;
	}


	public void setEndSessionEndpoint(String endSessionEndpoint) {
		this.endSessionEndpoint = endSessionEndpoint;
	}


	public String getJwksUri() {
		return jwksUri;
	}


	public void setJwksUri(String jwksUri) {
		this.jwksUri = jwksUri;
	}


	public String getCheckSessionIframe() {
		return checkSessionIframe;
	}


	public void setCheckSessionIframe(String checkSessionIframe) {
		this.checkSessionIframe = checkSessionIframe;
	}

}
