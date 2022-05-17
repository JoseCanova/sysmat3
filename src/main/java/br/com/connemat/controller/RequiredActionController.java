package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.RequiredActionService;

@Deprecated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/required-action" , produces = MediaType.APPLICATION_JSON_VALUE)
public class RequiredActionController {

	@Autowired
	@Qualifier("requiredActionService")
	private RequiredActionService requiredActionService;
	
	public RequiredActionController() {
	}

	@PutMapping(path = "/{userId}")
	public ResponseEntity<?> requiredActionsEmail(String userId, @RequestBody List<String> requiredActions) {
		return requiredActionService.requiredActionsEmail(userId, requiredActions);
	}

}
