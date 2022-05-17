package br.com.connemat.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.ServiceFiscalCodeBaseService;
import br.com.connemat.model.entity.ServiceFiscalCode;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/service-fiscal-codes" ,
produces=MediaType.APPLICATION_JSON_VALUE)
public class ServiceFiscalCodeController 
extends EntityController<ServiceFiscalCode, String  , ServiceFiscalCodeBaseService>{

	public ServiceFiscalCodeController(@Autowired ServiceFiscalCodeBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/service-fiscal-codes/"  + base.getId().toString();
	}
}