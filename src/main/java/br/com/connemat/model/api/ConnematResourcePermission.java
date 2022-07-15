package br.com.connemat.model.api;

import org.keycloak.representations.idm.authorization.ResourcePermissionRepresentation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnematResourcePermission extends ResourcePermissionRepresentation {

	public ConnematResourcePermission() {
	}

}
