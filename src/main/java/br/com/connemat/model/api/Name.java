package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Valid
public class Name{
	
	@NotEmpty(message = "{text.empty}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
}