package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.ReferenceType;
import br.com.connemat.sysmat.service.ReferenceTypeBaseService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(path="/reference-types" , 
produces=MediaType.APPLICATION_JSON_VALUE)
public class ReferenceTypeController
extends EntityController<ReferenceType, String , ReferenceTypeBaseService>{

	public ReferenceTypeController(@Autowired ReferenceTypeBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/reference-types/"+base.getId();
	}
	
}
