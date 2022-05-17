package br.com.connemat.rest.client.model;

import javax.validation.constraints.NotEmpty;

public class IdRepresentation {
	
	@NotEmpty
	public String id; 
	
	public IdRepresentation() {
	}

	public IdRepresentation(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
