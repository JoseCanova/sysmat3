package br.com.connemat.model.api;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLogoutRepresentation {

	@NotEmpty
	private String idToken;
	
	@NotEmpty
	private String redirectUrl;
	
	@NotEmpty
	private String clientId;
	
	@NotEmpty 
	private String userId;
	
	@NotEmpty
	private String sessionState;
	
	@NotEmpty
	private String clientSecret;
	
	public UserLogoutRepresentation() {
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionState() {
		return sessionState;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}