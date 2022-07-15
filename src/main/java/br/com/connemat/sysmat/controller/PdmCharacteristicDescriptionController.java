package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmCharacteristicDescription;
import br.com.connemat.sysmat.service.PdmCharacteristicDescriptionBaseService;

@RestController
@RequestMapping(path="/pdm-characteritic-descriptions")
public class PdmCharacteristicDescriptionController 
extends EntityController<PdmCharacteristicDescription,Long,PdmCharacteristicDescriptionBaseService>{

	public PdmCharacteristicDescriptionController(@Autowired PdmCharacteristicDescriptionBaseService serv) {
		super (serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-characteritic-descriptions/"+base.getId();
	}
	
}
