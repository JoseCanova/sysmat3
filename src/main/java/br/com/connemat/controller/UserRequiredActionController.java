package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.RequiredActionService;
import br.com.connemat.model.api.UserRequiredAction;
import br.com.connemat.service.config.UserRequiredActionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/required-actions")
public class UserRequiredActionController {

	@Autowired
	private UserRequiredActionService service; 
	
	@Autowired
	@Qualifier("requiredActionService")
	private RequiredActionService actionsService;
	
	public UserRequiredActionController() {
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<List<UserRequiredAction>> 
								getAvailableRequiredActions(@PathVariable(name = "id") String realmId){
		return  ResponseEntity.ok(service.getRequiredActions(realmId));
	}
	
	@PutMapping(path = "/send-email/{id}")
	public ResponseEntity<?> 
								requiredActionsEmail(@PathVariable(name = "id") String userId , List<String> requiredActions){
		return  actionsService.requiredActionsEmail(userId ,  requiredActions);
	}
	
	
}
