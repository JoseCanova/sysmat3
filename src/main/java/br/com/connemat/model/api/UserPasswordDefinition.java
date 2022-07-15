package br.com.connemat.model.api;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class UserPasswordDefinition {

	private @NotNull User user; 
	
	private @NotNull PasswordDefinition password;
	
	public UserPasswordDefinition() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PasswordDefinition getPassword() {
		return password;
	}

	public void setPassword(PasswordDefinition password) {
		this.password = password;
	}

}
