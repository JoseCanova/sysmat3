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
import br.com.connemat.sysmat.model.entity.CategoryDescription;
import br.com.connemat.sysmat.service.CategoryDescriptionBaseService;

@RestController
@RequestMapping(path = "/category-descriptions" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CategoryDescriptionController 
extends EntityController<CategoryDescription, Long , CategoryDescriptionBaseService>{

	public CategoryDescriptionController(@Autowired CategoryDescriptionBaseService service) {
		super(service);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/category-descriptions/"+base.getId();
	}

	
	@GetMapping(path="/category/{id}")
	public ResponseEntity<List<CategoryDescription>> findCategoryDescriptionByCategoryId(@PathVariable(name="id"  , required=true) Long id) {
		return  ResponseEntity.ok(service.findCategoryDescriptionByCategoryId(id));
	}

}
