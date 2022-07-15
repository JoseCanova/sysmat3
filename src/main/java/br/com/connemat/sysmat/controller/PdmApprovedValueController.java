package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmApprovedValue;
import br.com.connemat.sysmat.service.PdmApprovedValueBaseService;

@RestController
@RequestMapping(path="/pdm-approved-values",
produces=MediaType.APPLICATION_JSON_VALUE)
public class PdmApprovedValueController 
extends EntityController<PdmApprovedValue,Long,PdmApprovedValueBaseService>{
	
	public PdmApprovedValueController(@Autowired PdmApprovedValueBaseService ser) {
		super(ser);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-approved-values/"+base.getId();
	}
}
