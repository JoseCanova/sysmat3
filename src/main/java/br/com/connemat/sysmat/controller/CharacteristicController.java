package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Characteristic;
import br.com.connemat.sysmat.service.CharacteristicBaseService;

@RestController
@RequestMapping(path="/characteristics", 
produces=MediaType.APPLICATION_JSON_VALUE)
public class CharacteristicController 
extends EntityController<Characteristic , Long , CharacteristicBaseService>{

	public CharacteristicController(@Autowired CharacteristicBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/characteristics/" + base.getId();
	}
	
}
