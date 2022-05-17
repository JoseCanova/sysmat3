package br.com.connemat.sysmat.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.Company;

@Validated
public interface CompanyBaseService 
extends CrudBaseService<Company , Long> {

	Object deactivatedCompany(@Valid @NotNull Long id);
	
}
