package br.com.connemat.sysmat.service;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.PdmApprovedValue;

@Validated
public interface PdmApprovedValueBaseService extends 
CrudBaseService<PdmApprovedValue,Long>{
	
}
