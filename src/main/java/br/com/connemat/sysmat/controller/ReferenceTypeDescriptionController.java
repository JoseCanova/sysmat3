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
import br.com.connemat.sysmat.model.entity.ReferenceTypeDescription;
import br.com.connemat.sysmat.service.ReferenceTypeDescriptionBaseService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(path = "/reference-type-descriptions" , 
produces=MediaType.APPLICATION_JSON_VALUE)
public class ReferenceTypeDescriptionController
extends EntityController<ReferenceTypeDescription, Long , ReferenceTypeDescriptionBaseService> {

	public ReferenceTypeDescriptionController(@Autowired ReferenceTypeDescriptionBaseService service) {
		super(service);
	}

	
	@Override
	public String getBaseUrl(Base<?> base) {
		return ""+base.getId().toString();
	}

	@GetMapping(path="/reference-type-id/{id}")
	public ResponseEntity<List<ReferenceTypeDescription>> 
	findByReferenceTypeDescriptionsByReferenceTypeId(@PathVariable(name="id"  , required=true) String id){
		return ResponseEntity.ok(service.findByReferenceTypeDescriptionsByReferenceTypeId(id));
	}

}
