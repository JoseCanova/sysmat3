package br.com.connemat.sysmat.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.Manufacturer;

@Validated
public interface ManufacturerBaseService 
extends CrudBaseService<Manufacturer,Long> {


	Object deactivateManufacturer( @Valid  @NotNull Long id);

	
	
}