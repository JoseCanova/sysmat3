package br.com.connemat.sysmat.controller;

import org.keycloak.models.repository.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.rest.client.model.ClientEntitySecretRepresentation;

@RestController
@RequestMapping("/sysmat/client")
@Profile(value="keycloak")
public class ClientRealmController {

	@Autowired ClientEntityRepository repository;
	
	public ClientRealmController() {
	}
	
	@GetMapping(path="/self")
	public ClientEntitySecretRepresentation getSelf(){ 
		return repository
			.findByClientIdAndRealmId("sysmat", "connemat")
			.map(cr -> new ClientEntitySecretRepresentation(cr.getSecret() , cr.getClientId() , "connemat"))
			.orElse(null);
	}
	
}
