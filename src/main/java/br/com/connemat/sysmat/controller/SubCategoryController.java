package br.com.connemat.sysmat.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.controller.EntityController;
import br.com.connemat.sysmat.model.entity.SubCategory;
import br.com.connemat.sysmat.service.SubCategoryBaseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/subcategories" , 
produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class SubCategoryController 
extends EntityController<SubCategory, Long , SubCategoryBaseService>{

	public SubCategoryController(@Autowired SubCategoryBaseService service) {
		super(service);
	}

	@ApiResponses(value = {
			@ApiResponse(message = "Entity added sucessfully" , code = HttpStatus.SC_OK)
	})
	@GetMapping(path="/category-id/{id}")
	public ResponseEntity<List<SubCategory>> findSubCategoryByCatagoryId(@PathVariable(name="id",required=true) Long id) {
		return   ResponseEntity.ok(service.findSubCategoryByCatagoryId(id) );
	}
	
}
