package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Valid
public class PasswordDefinition {

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@NotEmpty
	private String value; 
	
	@NotEmpty
	private String type; 
	
	@NotNull
	private Boolean temporary; 
	
	public PasswordDefinition() {
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getTemporary() {
		return temporary;
	}

	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}
}
