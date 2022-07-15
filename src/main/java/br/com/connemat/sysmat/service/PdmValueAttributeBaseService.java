package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.PdmValueAttribute;

@Validated
public interface PdmValueAttributeBaseService
extends CrudBaseService<PdmValueAttribute,Long> {
	
	List<PdmValueAttribute> findByPdmValueId(@NotNull Long pdmValueId);
	
}
