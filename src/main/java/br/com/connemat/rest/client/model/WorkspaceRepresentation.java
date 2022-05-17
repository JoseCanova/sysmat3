package br.com.connemat.rest.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceRepresentation {

	private String id; 
	
	private String name; 
	
	private Boolean active;
	
	public WorkspaceRepresentation() {
	}

	public WorkspaceRepresentation(String id2, String name2) {
		this.id=id2; 
		this.name=name2;
		this.active=true;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
