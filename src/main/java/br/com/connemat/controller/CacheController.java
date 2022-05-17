package br.com.connemat.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.sysmat.model.entity.Category;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path="/cache_controller" , 
produces=MediaType.APPLICATION_JSON_VALUE)
public class CacheController {

	public CacheController() {
	}

	@PostMapping
	public <T extends Category> ResponseEntity<?> storeObect(@RequestBody T object){
		return ResponseEntity.ok(true);
	}
	
}
