package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.CustomSection;
import br.com.connemat.sysmat.service.CustomSectionBaseService;

@RestController
@RequestMapping(path = "/custom-sections" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CustomSectionController 
extends EntityController<CustomSection, Long , CustomSectionBaseService> {

	public CustomSectionController(@Autowired  CustomSectionBaseService service) {
		super(service);
	}


	String getBaseUrl(CustomSection cs) {
		return "/custom_sections/"+ cs.getId();
	}

}