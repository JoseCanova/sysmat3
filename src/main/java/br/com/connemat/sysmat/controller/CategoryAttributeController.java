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
import br.com.connemat.sysmat.model.entity.CategoryAttribute;
import br.com.connemat.sysmat.service.CategoryAttributeBaseService;

@RestController
@RequestMapping(path = "/category-attributes" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryAttributeController 
extends EntityController<CategoryAttribute, Long , CategoryAttributeBaseService>{

	public CategoryAttributeController(@Autowired CategoryAttributeBaseService service) {
		super(service);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/category-attributes"+base.getId();
	}
	
	@GetMapping(path="/category/{id}")
	public ResponseEntity<List<CategoryAttribute>> findCategoryAttributeByCategoryId(@PathVariable(name="id"  , required=true) Long id) {
		return  ResponseEntity.ok(service.findCategoryAttributeByCategoryId(id));
	}

}
