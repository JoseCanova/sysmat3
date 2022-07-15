package br.com.connemat.controller;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.connemat.Base;
import br.com.connemat.LazyAttributeBaseService;
import br.com.connemat.model.api.AttributeValue; 

public abstract class AttributeLazyController<T extends Base<ID>, ID extends Serializable, S extends LazyAttributeBaseService<T, ID>>
extends EntityController<T, ID, S> {

	public AttributeLazyController(S serv) {  
		super(serv);
	}
	
	@GetMapping(path="/attribute/{attr}/{id}" , produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getAttributeValue(@PathVariable(name ="id") ID id , @PathVariable(name ="attr")  String attributeName , @RequestHeader HttpHeaders headers){ 
		AttributeValue<?> opt = service.getLobAttribute(id, attributeName);
		byte[] val = opt.isPresent()? opt.getId().toString().getBytes(): null;
		return opt.isPresent()? ResponseEntity.ok().body(val):ResponseEntity.notFound().build();
	}


}
