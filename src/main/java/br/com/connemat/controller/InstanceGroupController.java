package br.com.connemat.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.InstanceGroupBaseService;
import br.com.connemat.model.api.Group;

@RestController
@RequestMapping(path = "/instance-groups" , 
				produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins = "*")
@Profile(value="keycloak")
public class InstanceGroupController{

	@Autowired
	@Qualifier("instanceGroupBaseService")
	private InstanceGroupBaseService service;
	
	public InstanceGroupController() {
	}

	@GetMapping(path="/self")
	public ResponseEntity<List<Group>> getInstances() 
	{
		return ResponseEntity.ok(service.getInstances());
	}

	@GetMapping(path="/{groupId}")
	public ResponseEntity<List<Group>> getInstanceGroups(@PathVariable(name = "groupId") String instanceGroupId) 
	{
		return ResponseEntity.ok(service.getInstanceGroups(instanceGroupId));
	}

	@GetMapping(path="/user-groups")
	public ResponseEntity<List<Group>> getUserInstances(@CurrentSecurityContext(expression = "authentication") Authentication authentication) 
	{
		return ResponseEntity.ok(service.getUserInstances(authentication));
	}

	@GetMapping(path="/user-groups/{groupId}")
	public ResponseEntity<List<Group>> getUserInstanceSubGroups(@CurrentSecurityContext(expression = "authentication") Authentication authentication,
			@NotEmpty String instanceGroupId) {
		return ResponseEntity.ok(service.getUserInstanceSubGroups(authentication, instanceGroupId));
	}

}