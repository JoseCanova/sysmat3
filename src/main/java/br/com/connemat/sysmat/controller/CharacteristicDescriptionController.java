package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.CharacteristicDescription;
import br.com.connemat.sysmat.service.CharacteristicDescriptionBaseService;

@RestController
@RequestMapping(path="/characteristic-descriptions", 
produces=MediaType.APPLICATION_JSON_VALUE)
public class CharacteristicDescriptionController
extends EntityController<CharacteristicDescription , Long , CharacteristicDescriptionBaseService>{

	public CharacteristicDescriptionController(@Autowired CharacteristicDescriptionBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/characteristic-descriptions/"+base.getId();
	}
	
}
