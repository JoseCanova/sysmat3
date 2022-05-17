package br.com.connemat.sysmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.Category;
import br.com.connemat.sysmat.service.CategoryBaseService;

@RestController
@RequestMapping(path = "/categories" , 
produces= MediaType.APPLICATION_JSON_VALUE)
public class CategoryController
extends EntityController<Category, Long , CategoryBaseService>{

	public CategoryController(@Autowired CategoryBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/categories/"+base.getId();
	}
	
}
