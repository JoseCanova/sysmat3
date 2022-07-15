package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.ClientBaseService;
import br.com.connemat.model.api.Client;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/client" ,  produces=MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

	@Autowired
	@Qualifier("clientBaseService")
	private ClientBaseService clientBaseService;
	
	public ClientController() {
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> getClients(){
		return ResponseEntity.ok(clientBaseService.getClients());
	}

}
