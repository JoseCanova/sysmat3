package br.com.connemat.controller;

import java.io.Serializable;
import java.net.URI;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.connemat.Base;
import br.com.connemat.BaseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class EntityController 
<T extends Base<ID>, ID extends Serializable , S extends BaseService<T,ID>> 
extends PageableController<T, S>{

	public EntityController(S serv) {
		super(serv);
	}

	@ApiResponses(value = {
			@ApiResponse(message = "Entity Added sucessfully" , code = HttpStatus.SC_CREATED), 
			@ApiResponse(message = "Constraint Violation ou Data Integrity Exception" , code = HttpStatus.SC_CONFLICT), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada" , code = HttpStatus.SC_UNAUTHORIZED) 
			})
	@PostMapping
	public ResponseEntity<T> addEntity(@RequestBody T entity){
		T savedEntity = service.addEntity(entity);
		return ResponseEntity.created(URI.create(getBaseUrl(savedEntity))).body(savedEntity);
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity Added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "Constraint Violation Exception" , code = HttpStatus.SC_CONFLICT), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuario nao possui nivel de acesso para operacao" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "NoSuchElementException Unauthorized - Quando Entity Não é Encontrado" , code = HttpStatus.SC_NOT_FOUND) 
	})
	@PutMapping(path="/{id}")
	public ResponseEntity<T> updateEntity (@PathVariable(name="id",required=true) ID id  , @RequestBody T entity){
		return ResponseEntity.accepted().body(service.updateEntity(id, entity));
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity Added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuario nao possui nivel de acesso para operacao" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "NoSuchElementException  - Quando Entity Não é Encontrado" , code = HttpStatus.SC_NOT_FOUND) 
	})
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteEntity(@PathVariable(name="id",required=true) ID id ){
		return ResponseEntity.accepted().body(service.deleteEntity(id));
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity Added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuario nao possui nivel de acesso para operacao" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "NoSuchElementException  - Quando Entity Não é Encontrado" , code = HttpStatus.SC_NOT_FOUND) 
	})
	@GetMapping(path="/{id}")
	public ResponseEntity<T> findByEntityId(@PathVariable(name="id",required=true) ID id ){
		return ResponseEntity.ok(service.findByEntityId(id));
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuario nao possui nivel de acesso para operacao" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "SysmatEntityException  - Quando a propriedade não é encontrada" , code = HttpStatus.SC_NOT_FOUND) 
	})
	@GetMapping(path="/{id}/{property}")
	public ResponseEntity<T> findByEntityIdFetchProperty(@PathVariable(name="id",required=true) ID id , 
			@PathVariable(name="property",required=true) String property){
		return ResponseEntity.ok(service.findByEntityIdFetchProperty(id,property));
	}
	
}
