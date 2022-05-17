package br.com.connemat.model.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.connemat.model.api.validation.ClientRoleValidation;
import br.com.connemat.model.api.validation.GroupAttributeValidation;
import br.com.connemat.model.api.validation.GroupUpdateValidation;
import br.com.connemat.model.api.validation.RealmRoleValidation;
import br.com.connemat.model.api.validation.SubGroupValidation;

@Valid
@JsonInclude(Include.NON_NULL)
public class Group {

	@NotEmpty(groups = GroupUpdateValidation.class)
	private String id; 
	
	@NotEmpty
	private String name;
	
	private String path; 
	
	
	@NotEmpty(groups = GroupAttributeValidation.class)
	private List<GroupAttribute> attributes;
	
	@NotEmpty(groups = RealmRoleValidation.class)
	private List<String> realmRoles;
	
	@NotEmpty(groups = SubGroupValidation.class)
	private List<Group> subGroups;
	
	
	@NotEmpty(groups = ClientRoleValidation.class)
	private Map<String , List<String>> clientRoles;
	
	
	public Group() {
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public List<GroupAttribute> getAttributes() {
		if (attributes == null) 
			attributes = new ArrayList<>();
		return attributes;
	}


	public void setAttributes(List<GroupAttribute> attributes) {
		this.attributes = attributes;
	}


	public List<String> getRealmRoles() {
		if (realmRoles == null) 
			realmRoles = new ArrayList<>();
		return realmRoles;
	}


	public void setRealmRoles(List<String> realmRoles) {
		this.realmRoles = realmRoles;
	}


	public List<Group> getSubGroups() {
		if (subGroups == null) 
			subGroups = new ArrayList<>();
		return subGroups;
	}


	public void setSubGroups(List<Group> subGroups) {
		this.subGroups = subGroups;
	}

	public Map<String, List<String>> getClientRoles() {
		if (clientRoles == null) 
			clientRoles = new HashMap<>();
		return clientRoles;
	}


	public void setClientRoles(Map<String, List<String>> clientRoles) {
		this.clientRoles = clientRoles;
	}


	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", path=" + path + ", attributes=" + attributes + ", realmRoles="
				+ realmRoles + ", subGroups=" + subGroups + ", clientRoles=" + clientRoles + "]";
	}
	
	
}
