package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.ServiceFiscalCodeTreeBaseService;
import br.com.connemat.model.entity.ServiceFiscalCodeTree;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/service-fiscal-code-trees" ,
produces=MediaType.APPLICATION_JSON_VALUE)
public class ServiceFiscalCodeTreeController 
extends EntityController<ServiceFiscalCodeTree, Long , ServiceFiscalCodeTreeBaseService>{

	public ServiceFiscalCodeTreeController(@Autowired ServiceFiscalCodeTreeBaseService service) {
		super(service);
	}


}