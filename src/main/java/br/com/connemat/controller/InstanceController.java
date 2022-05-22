package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.InstanceBaseService;
import br.com.connemat.model.entity.Instance;

@RestController
@RequestMapping(path="/instances" , produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@Profile(value="keycloak")
public class InstanceController 
extends AttributeLazyController<Instance , Long , InstanceBaseService>{
	
	public InstanceController(@Autowired InstanceBaseService serv) {
		super(serv);
	}

	@GetMapping(path="/sector-id/{sectorId}")
	public ResponseEntity<List<Instance>> findIntanceBySectorId(@PathVariable(name ="sectorId") Long sectorId){
		return ResponseEntity.ok(service.findIntanceBySectorId(sectorId));
	}
	
	@PostMapping(path="/activate-instance" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> activateInstance(@RequestBody  Instance instance){
		return ResponseEntity.ok( service.activateInstance(instance));
	}
}
