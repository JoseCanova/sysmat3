package br.com.connemat.rest.client.model;


public class ClientEntitySecretRepresentation{ 
	
	private String secret; 
	
	private String clientId; 
	
	private String realmId; 
	
	public ClientEntitySecretRepresentation(){}
	
	public ClientEntitySecretRepresentation(String secret , String name , String realmId){ 
		this.secret = secret; 
		this.clientId = name;
		this.realmId = realmId;
	}
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRealmId() {
		return realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}
}