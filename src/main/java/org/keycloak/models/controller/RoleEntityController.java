package org.keycloak.models.controller;

import java.util.List;

import org.keycloak.models.controller.services.RoleEntityService;
import org.keycloak.models.jpa.entities.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/role_entity", 
produces = MediaType.APPLICATION_JSON_VALUE)
@Profile(value="keycloak")
public class RoleEntityController {

	@Autowired
	private RoleEntityService service;
	
	@GetMapping
	public ResponseEntity<List<RoleEntity>> getSysmatActionRoles(){
		return ResponseEntity.ok(service.getSysmatActionRoles());
	}
	
}