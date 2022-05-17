package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmApprovedValueDescription;
import br.com.connemat.sysmat.service.PdmApprovedValueDescriptionBaseService;

@RestController
@RequestMapping(path="/pdm-approved-value-descriptions",
produces=MediaType.APPLICATION_JSON_VALUE)
public class PdmApprovedValueDescriptionController 
extends EntityController<PdmApprovedValueDescription,Long,PdmApprovedValueDescriptionBaseService>
{

	public PdmApprovedValueDescriptionController(
						@Autowired PdmApprovedValueDescriptionBaseService  serv) 
	{
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-approved-value-descriptions/"+base.getId();
	}

}
