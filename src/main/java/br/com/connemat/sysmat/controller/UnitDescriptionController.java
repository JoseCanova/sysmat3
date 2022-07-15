package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.UnitDescription;
import br.com.connemat.sysmat.service.UnitDescriptionBaseService;

@RestController
@RequestMapping(path = "/unit-descriptions" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UnitDescriptionController 
extends EntityController<UnitDescription , Long , UnitDescriptionBaseService>{

	public UnitDescriptionController(@Autowired UnitDescriptionBaseService service) {
		super(service);
	}


	@Override
	public String getBaseUrl(Base<?> base) {
		return "/unit-descriptions/"+base.getId();
	}
	
}
