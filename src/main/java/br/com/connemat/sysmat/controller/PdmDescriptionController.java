package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmDescription;
import br.com.connemat.sysmat.service.PdmDescriptionBaseService;

@RestController
@RequestMapping(path="/pdm-descriptions")
public class PdmDescriptionController 
extends EntityController<PdmDescription , Long , PdmDescriptionBaseService>{

	public PdmDescriptionController(@Autowired PdmDescriptionBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-descriptions/"+base.getId();
	}

}
