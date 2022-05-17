package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Valid
public class UserGroupRealm {

	@NotEmpty
	private String userId; 
	
	@NotEmpty
	private String groupId; 
	
	@NotEmpty
	private String realm; 
	
	public UserGroupRealm() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}
	
}
