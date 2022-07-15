package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Valid
public class GroupAttribute {

	@NotEmpty
	private String name; 
	
	@NotEmpty
	private String value; 
	
	public GroupAttribute() {
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

	@Override
	public String toString() {
		return "GroupAttribute [name=" + name + ", value=" + value + "]";
	}

}
