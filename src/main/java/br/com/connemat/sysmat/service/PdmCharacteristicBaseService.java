package br.com.connemat.sysmat.service;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.PdmCharacteristic;

@Validated
public interface PdmCharacteristicBaseService 
extends CrudBaseService<PdmCharacteristic  , Long>{

	
}
