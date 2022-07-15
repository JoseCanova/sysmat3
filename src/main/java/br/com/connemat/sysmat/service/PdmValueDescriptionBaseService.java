package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.PdmValueDescription;

@Validated
public interface PdmValueDescriptionBaseService 
extends CrudBaseService<PdmValueDescription,Long> {

	@NotEmpty List<PdmValueDescription> findByPdmValueId(@NotNull Long pdmValueId);
	
}
