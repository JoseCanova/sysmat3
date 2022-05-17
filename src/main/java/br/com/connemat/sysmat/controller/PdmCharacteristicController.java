package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmCharacteristic;
import br.com.connemat.sysmat.service.PdmCharacteristicBaseService;

@RestController
@RequestMapping(path="/pdm-characteristics",
produces=MediaType.APPLICATION_JSON_VALUE)
public class PdmCharacteristicController 
extends EntityController<PdmCharacteristic,Long,PdmCharacteristicBaseService>{

	public PdmCharacteristicController(@Autowired PdmCharacteristicBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-characteristics/"+base.getId();
	}	

}
