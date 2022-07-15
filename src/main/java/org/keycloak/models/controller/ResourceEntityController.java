package org.keycloak.models.controller;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.ResourceEntity;
import org.keycloak.models.repository.ResourceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/resource_entity", 
produces = MediaType.APPLICATION_JSON_VALUE )
@Profile(value="keycloak")
public class ResourceEntityController {

	@Autowired 
	ResourceEntityRepository repository; 
	
	public ResourceEntityController() {
	}
	
	@GetMapping
	public ResponseEntity<List<ResourceEntity>> findAll(){
		return ResponseEntity.of(Optional.of(repository.findAll()));
	}

}
