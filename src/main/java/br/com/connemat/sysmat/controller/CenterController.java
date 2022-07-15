package br.com.connemat.sysmat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Center;
import br.com.connemat.sysmat.service.CenterBaseService;

@RestController
@RequestMapping(path = "/centers" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CenterController 
extends EntityController<Center, Long , CenterBaseService> {

	
	public CenterController(
			@Autowired CenterBaseService service) {
		super(service);
	}

	@PutMapping(path="/deactivate/{id}")
	public Object deactivateCenter(@PathVariable(name="id", required=true)  Long id) {
		return ResponseEntity.accepted().body(service.deactivateCenter(id));
	}

	
	@GetMapping(path="/company/{id}")
	public ResponseEntity<List<Center>> findCentersByCompanyId(@PathVariable(name="id" , required=true) Long id){
		return ResponseEntity.ok(service.findCenterByCompanyId(id));
	}
}
