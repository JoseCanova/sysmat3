package br.com.connemat.model.api;

import javax.validation.constraints.NotEmpty;

public class RoleAttribute {

	@NotEmpty
	private String name; 
	
	@NotEmpty
	private String value;
	
	public RoleAttribute() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
