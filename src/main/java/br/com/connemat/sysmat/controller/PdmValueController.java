package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmValue;
import br.com.connemat.sysmat.service.PdmValueBaseService;

@RestController
@RequestMapping(path = "/pdm-values" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PdmValueController 
extends EntityController<PdmValue, Long  , PdmValueBaseService> {

	public PdmValueController(@Autowired PdmValueBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return  "/pdm-values/"+base.getId();
	}
}
