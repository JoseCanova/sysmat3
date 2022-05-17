package br.com.connemat.sysmat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmApprovedValueAttribute;
import br.com.connemat.sysmat.service.PdmApprovedValueAttributeBaseService;

@RestController
@RequestMapping(path="/pdm-approved-value-attributes",produces=MediaType.APPLICATION_JSON_VALUE)
public class PdmApprovedValueAttributeController 
extends EntityController<PdmApprovedValueAttribute,Long,PdmApprovedValueAttributeBaseService>{

	public PdmApprovedValueAttributeController(@Autowired PdmApprovedValueAttributeBaseService serv) {
		super(serv);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-approved-value-attributes/"+base.getId();
	}
	
	@GetMapping(path="/pdm-approved-value-id/{id}")
	public List<PdmApprovedValueAttribute> findByPdmApprovedValueId(@PathVariable(name="id") Long id){
		return service.findByPdmApprovedValueId(id);
	}

}
