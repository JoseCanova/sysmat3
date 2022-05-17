package br.com.connemat.sysmat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmCharacteristicAttribute;
import br.com.connemat.sysmat.service.PdmCharacteristicAttributeBaseService;

@RestController
@RequestMapping(path="/pdm-characteristic-attributes")
public class PdmCharacteristicAttributeController 
extends EntityController<PdmCharacteristicAttribute,Long,PdmCharacteristicAttributeBaseService>{

	public PdmCharacteristicAttributeController(@Autowired PdmCharacteristicAttributeBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-characteristic-attributes/"+base.getId();
	}
	
	@GetMapping(path="/pdm-characteristic-id/{id}")
	public List<PdmCharacteristicAttribute> findByPdmCharacteristicId(@PathVariable(name="id",required=true) Long id) {
		return service.findByPdmCharacteristicId(id);
	}
	
}
