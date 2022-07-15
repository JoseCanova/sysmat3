package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Company;
import br.com.connemat.sysmat.service.CompanyBaseService;

@RestController
@RequestMapping(path = "/companies" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CompanyController 
extends EntityController<Company, Long , CompanyBaseService> {

	public CompanyController(@Autowired CompanyBaseService service) {
		super(service);
	}

	@PutMapping(path="/deactivate/{id}")
	public ResponseEntity<Object> deactivatedCompany(@PathVariable(name="id" , required=true)  Long id) {
		return new ResponseEntity<>(  service.deactivatedCompany(id), HttpStatus.ACCEPTED);
	}
	
}
