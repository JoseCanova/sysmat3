package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.CustomField;

@Validated
public interface CustomFieldBaseService 
extends CrudBaseService<CustomField , Long> {

	
	List<CustomField> findCustomFieldByCustomConfigValueId(@Valid @NotNull Long id);
	
}
