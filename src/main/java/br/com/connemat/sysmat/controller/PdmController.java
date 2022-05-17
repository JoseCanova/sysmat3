package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Pdm;
import br.com.connemat.sysmat.service.PdmBaseService;


@RestController
@RequestMapping(path="/pdms", produces=MediaType.APPLICATION_JSON_VALUE)
public class PdmController 
extends EntityController<Pdm  , Long  , PdmBaseService>{

	public PdmController(@Autowired PdmBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdms/" + base.getId();
	}

}
