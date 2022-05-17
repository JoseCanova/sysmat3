package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Unit;
import br.com.connemat.sysmat.service.UnitBaseService;

@RestController
@RequestMapping(path = "/units" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UnitController 
extends EntityController<Unit , Long , UnitBaseService>{

	
	public UnitController(	@Autowired
			@Qualifier(value="unitBaseService")
			UnitBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/units/"+base.getId().toString();
	}

	@PutMapping(path="/deactivate/{id}")
	public ResponseEntity<Object> deactivateUnit(@PathVariable(name="id",required = true)  Long id) {
		return ResponseEntity.accepted().body(service.deactivateUnit(id));
	}
}
