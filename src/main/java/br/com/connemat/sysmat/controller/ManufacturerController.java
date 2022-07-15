package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Manufacturer;
import br.com.connemat.sysmat.service.ManufacturerBaseService;


@RestController
@RequestMapping(path = "/manufacturers" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ManufacturerController 
extends EntityController<Manufacturer, Long , ManufacturerBaseService>{
	
	
	public ManufacturerController(@Autowired ManufacturerBaseService serv) {
		super(serv);
	}
	
	@PutMapping(path="/deactivate/{id}")
	public ResponseEntity<Object> deactivateManufacturer(@PathVariable(name = "id")Long id){
		return ResponseEntity.accepted().body(service.deactivateManufacturer(id));
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/manufacturers/"+base.getId().toString();
	}
}

