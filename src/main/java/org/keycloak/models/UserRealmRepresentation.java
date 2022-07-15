package org.keycloak.models;

public class UserRealmRepresentation {

	private String userId; 
	
	private String realmId;
	
	public UserRealmRepresentation() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRealmId() {
		return realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}

}
