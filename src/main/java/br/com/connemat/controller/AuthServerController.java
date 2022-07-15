package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.model.api.UserLogoutRepresentation;
import br.com.connemat.rest.client.AdminRestClient;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/logout_all")
public class AuthServerController {

	@Autowired 
	private AdminRestClient adminRestClient;
	
	@PostMapping(
					consumes= {MediaType.TEXT_PLAIN_VALUE,MediaType.APPLICATION_JSON_VALUE} , 
					produces= {MediaType.TEXT_PLAIN_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> processLogout
						(@RequestBody UserLogoutRepresentation userLogoutRepresentation , 
						 @CurrentSecurityContext(expression = "authentication") Authentication authentication){
		return adminRestClient.logoutUserSessions(userLogoutRepresentation , authentication);
	}
}