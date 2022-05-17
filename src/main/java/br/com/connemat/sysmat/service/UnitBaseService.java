package br.com.connemat.sysmat.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.Unit;

@Validated
public interface UnitBaseService 
extends CrudBaseService<Unit,Long>{
	Object deactivateUnit(@Valid @NotNull Long id);
	
}
