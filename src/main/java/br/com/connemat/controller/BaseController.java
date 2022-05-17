package br.com.connemat.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.connemat.Base;
import br.com.connemat.BaseService;
import br.com.connemat.UrlBaseLocator;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public abstract class BaseController<T extends Base<?>  , S extends BaseService<T,?>> 
implements UrlBaseLocator {

	public static final Integer MAX_FIND_ALL = Integer.MAX_VALUE-1;

	protected S service;
	
	public BaseController(S serv) {
		this.service = serv;
	}
	
	public BaseController() { 
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuário nao possui nivel de acesso para operação" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "RuntimeException  - " , code = HttpStatus.SC_INTERNAL_SERVER_ERROR) 
	})
	@DeleteMapping(path="/delete-list")
	public ResponseEntity<?> deleteAll(@RequestBody List<T> items){
		service.deleteAll(items);
		return ResponseEntity.accepted().body(true);
	}
	
	@ApiResponses(value = {
			@ApiResponse(message = "Entity added sucessfully" , code = HttpStatus.SC_OK), 
			@ApiResponse(message = "AccessDeniedException Unauthorized - Quando Segurança Ativada e usuário nao possui nivel de acesso para operação" , code = HttpStatus.SC_UNAUTHORIZED), 
			@ApiResponse(message = "RuntimeException  - " , code = HttpStatus.SC_INTERNAL_SERVER_ERROR) 
	})
	@PutMapping(path="/update-list")
	public ResponseEntity<?> salveAll(@RequestBody List<T> items){
		return ResponseEntity.accepted().body(service.saveAll(items));
	}
	
}
