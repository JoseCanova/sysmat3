package org.keycloak.models.utils;

import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.Role;

@Component
public class RoleRepresentationConverter extends Converter<RoleRepresentation,Role>{

	public RoleRepresentationConverter() {
	}

	@Override
	public Role doForward(RoleRepresentation a) {
		Role role = new Role();
		role.setId(a.getId());
		role.setName(a.getName());
		role.setClientRole(a.getClientRole());
		role.setDescription(a.getDescription());
		return role;
	}

	@Override
	public RoleRepresentation doBackward(Role b) {
		RoleRepresentation rr = new RoleRepresentation(); 
		rr.setId(b.getId());
		rr.setName(b.getName());
		rr.setClientRole(b.getClientRole());
		rr.setDescription(b.getDescription());
		return rr;
	}

}
