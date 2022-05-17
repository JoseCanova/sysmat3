package br.com.connemat.sysmat.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.CustomValue;
import br.com.connemat.sysmat.service.CustomValueBaseService;

@RestController
@RequestMapping(path = "/custom-values" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CustomValueController 
extends EntityController<CustomValue  , Long , CustomValueBaseService>{

	public CustomValueController(@Autowired CustomValueBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return URI.create("/custom_values/" + base.getId().toString()).toString();
	}

}
