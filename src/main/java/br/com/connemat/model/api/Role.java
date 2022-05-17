package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.connemat.model.api.validation.UpdateRoleValidationGroup;

@Valid
public class Role {

	@NotEmpty(groups = UpdateRoleValidationGroup.class)
	@Size(max=36)
	private String id; 
	
	@NotEmpty
	@Size(max=255)
	private String name;
	
	private String description;
	
	@NotNull
	private Boolean clientRole;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Role() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getClientRole() {
		return clientRole;
	}

	public void setClientRole(Boolean clientRole) {
		this.clientRole = clientRole;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", clientRole=" + clientRole
				+ "]";
	}

}
