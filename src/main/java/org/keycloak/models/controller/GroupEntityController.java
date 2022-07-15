package org.keycloak.models.controller;

import java.util.List;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.GroupBaseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/group_entity", 
		produces = MediaType.APPLICATION_JSON_VALUE )
@Profile(value="keycloak")
public class GroupEntityController {
	
	@Autowired
	GroupBaseService service; 
	
	public GroupEntityController() {
	}

	@GetMapping(path = "/{realm}")
	List<GroupEntity> getGroupsByRealm(@PathVariable(name = "realm") String realm){ 
		return service.findByRealm(realm);
	}
	
	@GetMapping(path = "/{attribute}/{realm}")
	List<GroupEntity> getGroupsByAttributeAndRealm
													(@PathVariable(name = "attribute") String attribute , 
													@PathVariable(name = "realm") String realm){ 
		return service.findByAttributesNameAndRealm(attribute, realm);
	}
	
}
