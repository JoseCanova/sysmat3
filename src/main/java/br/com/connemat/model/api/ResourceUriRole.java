package br.com.connemat.model.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.authorization.DecisionStrategy;


@Valid
public class ResourceUriRole implements UrlAccessor<List<String>> , RoleAccessor<List<String>>{

	@NotEmpty(groups = {LoadedResourceValidationGroup.class})
	private String id; 
	
	@NotEmpty(groups = {LoadedResourceValidationGroup.class})
	private String name; 
	
	@NotEmpty(groups = {LoadedResourceValidationGroup.class})
	private List<String> uris;
	
	@NotEmpty(groups = {RolesValidationGroup.class})
	private List<String> roles;
	
	private List<String> groups;
	
	//TODO:Não utilizar ainda. criar o decision strategy baseado no spring security.
	@NotNull
	private DecisionStrategy decisionStrategy;
	
	public ResourceUriRole() {
		uris  = new ArrayList<>();
		roles = new ArrayList<>();
		groups = new ArrayList<>();
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getUris() {
		return uris;
	}

	public void setUris(List<String> uris) {
		this.uris = uris;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Optional
				.ofNullable(obj)
				.filter(o -> this.getClass().isInstance(o))
				.map(theObject -> {
					ResourceUriRole robj =  this.getClass().cast(obj);
					return Objects.equals(id, robj.getId());
				}).orElse(false);
	}

	//TODO:verificar method validation groups novamente.
	public boolean addRole(@NotNull RoleRepresentation rrep) {
		return Optional
			.ofNullable(rrep.getName())
			.map(name -> roles.add(name)).orElse(false);
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public void addGroup(GroupRepresentation gp) {
		groups.add(gp.getPath());
	}

	public void setDecisionStrategy(final DecisionStrategy decisionStrategy) {
		this.decisionStrategy = decisionStrategy;
	}

	public DecisionStrategy getDecisionStrategy() {
		return decisionStrategy;
	}
}
