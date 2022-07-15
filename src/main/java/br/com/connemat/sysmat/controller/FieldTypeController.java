package br.com.connemat.sysmat.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.FieldType;
import br.com.connemat.sysmat.model.entity.util.FieldTypeEnum;
import br.com.connemat.sysmat.service.FieldTypeBaseService;

@RestController
@RequestMapping(path = "/field-types" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class FieldTypeController 
extends EntityController<FieldType, FieldTypeEnum, FieldTypeBaseService>{

	public FieldTypeController(@Autowired FieldTypeBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return URI.create("/field_types/"+base.getId().toString()).toString();
	}
	
}
