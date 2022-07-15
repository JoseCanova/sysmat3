package br.com.connemat.rest.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthToken {

   @JsonProperty(value = "access_token")	
   private String accessToken;
   
   @JsonProperty(value="expires_in")
   private Integer expiresIn;

   @JsonProperty(value="refresh_expires_in")
   private Integer refreshExpiresIn;

   @JsonProperty(value="refresh_token")
   private String refreshToken;
	
   @JsonProperty(value="token_type")
   private String tokenType; 
   
   @JsonIgnore
   private Long expirationTime; 
   
	public AuthToken() {
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Integer getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	public void setRefreshExpiresIn(Integer refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

}
