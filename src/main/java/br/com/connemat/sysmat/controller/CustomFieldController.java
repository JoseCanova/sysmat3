package br.com.connemat.sysmat.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.CustomField;
import br.com.connemat.sysmat.service.CustomFieldBaseService;

@RestController
@RequestMapping(path = "/custom-fields" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CustomFieldController 
extends EntityController<CustomField, Long , CustomFieldBaseService>{

	public CustomFieldController(@Autowired CustomFieldBaseService service) {
		super(service);
	}

	@GetMapping(path="/custom_config/{id}")
	public ResponseEntity<List<CustomField>> findCustomFieldByCustomConfigValueId(@Valid @NotNull Long id) {
		return ResponseEntity.ok(service.findCustomFieldByCustomConfigValueId(id));
	}

}
