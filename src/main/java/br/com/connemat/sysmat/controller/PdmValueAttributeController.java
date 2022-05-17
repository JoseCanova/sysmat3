package br.com.connemat.sysmat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmValueAttribute;
import br.com.connemat.sysmat.service.PdmValueAttributeBaseService;

@RestController
@RequestMapping(path = "/pdm-value-attributes" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PdmValueAttributeController
extends EntityController<PdmValueAttribute, Long , PdmValueAttributeBaseService> {

	public PdmValueAttributeController(@Autowired PdmValueAttributeBaseService serv) {
		super(serv);
	}

	@GetMapping(path="/pdm-value-id/{id}")
	public  ResponseEntity< List<PdmValueAttribute>> findPdmValueId(@PathVariable(name="id", required=true) Long id) {
		return   ResponseEntity.ok (service.findByPdmValueId(id));
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-value-attributes/"+base.getId().toString();
	}
	
}
