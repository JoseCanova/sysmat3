package org.keycloak.models.controller;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.ClientEntity;
import org.keycloak.models.repository.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/client_entity", 
produces = MediaType.APPLICATION_JSON_VALUE)
@Profile(value="keycloak")
public class ClientEntityController {

    @Autowired ClientEntityRepository repository;
	
	public ClientEntityController() {
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<ClientEntity>> getClientEntities(){ 
		return ResponseEntity.of(Optional.of(repository.findAll()));
	}
	
	@GetMapping(path="/{realm}/{id}")
	@Transactional("keycloak-tm")
	public ResponseEntity<ClientEntity> getClientEntitiesByIdAndRealm(@PathVariable(name = "id") String id, 
			@PathVariable(name="realm") String realm){ 
		return  ResponseEntity.of(repository.findByClientIdAndRealmId(id,realm));
	}
	
	@GetMapping(path="/{realm}")
	@Transactional("keycloak-tm")
	public ResponseEntity<List<ClientEntity>> getClientEntities(@PathVariable(name = "realm") String realm){ 
		return  ResponseEntity.of(Optional.of(repository.findByRealmId(realm)));
	}
	
}

