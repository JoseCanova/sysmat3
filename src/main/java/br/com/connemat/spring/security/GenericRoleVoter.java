package br.com.connemat.spring.security;

import org.springframework.security.access.vote.RoleVoter;
public class GenericRoleVoter extends RoleVoter {

	public GenericRoleVoter() {
		this.setRolePrefix("ROLE_");
	}

}
