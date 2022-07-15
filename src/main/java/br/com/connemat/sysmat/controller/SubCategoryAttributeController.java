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
import br.com.connemat.sysmat.model.entity.SubCategoryAttribute;
import br.com.connemat.sysmat.service.SubCategoryAttributeBaseService;

@RestController
@RequestMapping(path = "/subcategory-attributes" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SubCategoryAttributeController 
extends EntityController<SubCategoryAttribute, Long, SubCategoryAttributeBaseService>{

	public SubCategoryAttributeController(@Autowired SubCategoryAttributeBaseService service) {
		super(service);
	}
	
	@Override
	public String getBaseUrl(Base<?> base) {
		return "/subcategory-attributes/"+base.getId().toString();
	}
	
	@GetMapping(path="/subcategory-id/{id}")
	public ResponseEntity<List<SubCategoryAttribute>> findSubCategoryAttributeBySubCategoryId(@PathVariable(name="id",required=true)  Long id){
		return ResponseEntity.ok( service.findSubCategoryAttributeBySubCategoryId(id));
	}

}
