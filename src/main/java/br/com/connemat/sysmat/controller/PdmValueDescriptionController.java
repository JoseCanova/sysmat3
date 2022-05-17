package br.com.connemat.sysmat.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.PdmValueDescription;
import br.com.connemat.sysmat.service.PdmValueDescriptionBaseService;

@RestController
@RequestMapping(path = "/pdm-value-descriptions" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PdmValueDescriptionController
extends EntityController<PdmValueDescription, Long , PdmValueDescriptionBaseService> {

	public PdmValueDescriptionController(PdmValueDescriptionBaseService service) {
		super(service);
	}

	@GetMapping(path="/pdm-value-id/{id}")
	public ResponseEntity<List<PdmValueDescription>> findByPdmValueId(@PathVariable(name="id", required=true) Long pdmValueId) {
		return ResponseEntity.ok(service.findByPdmValueId(pdmValueId));
	}	

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/pdm-value-descriptions/"+base.getId().toString();
	}
	
}
