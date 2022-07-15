package org.keycloak.models.utils;

import org.keycloak.models.jpa.entities.RoleEntity;
import org.keycloak.representations.idm.RoleRepresentation;

import com.google.common.base.Converter;

public class RoleEntityRepresentationConverter extends Converter<RoleEntity, RoleRepresentation> {

	@Override
	public RoleRepresentation doForward(RoleEntity a) {
		return null;
	}

	@Override
	public RoleEntity doBackward(RoleRepresentation b) {
		return null;
	}

}
