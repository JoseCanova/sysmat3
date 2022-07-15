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
import br.com.connemat.sysmat.model.entity.SubCategoryDescription;
import br.com.connemat.sysmat.service.SubCategoryDescriptionBaseService;

@RestController
@RequestMapping(path = "/subcategory-descriptions" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SubCategoryDescriptionController 
extends EntityController<SubCategoryDescription, Long , SubCategoryDescriptionBaseService>{

	public SubCategoryDescriptionController(@Autowired SubCategoryDescriptionBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return  "/subcategory-descriptions/"+base.getId();
	}
	
	@GetMapping(path="/subcategory-id/{id}")
	public ResponseEntity<List<SubCategoryDescription>> findSubCategoryByCategoryId(@PathVariable(name="id"  , required=true) Long id) {
		return ResponseEntity.ok(service.findSubCategoryByCategoryId(id));
	}
}
