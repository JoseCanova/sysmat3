package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.ReferenceTypeDescription;

@Validated
public interface ReferenceTypeDescriptionBaseService 
extends CrudBaseService<ReferenceTypeDescription, Long> {


	List<ReferenceTypeDescription> 
		findByReferenceTypeDescriptionsByReferenceTypeId(@Valid @NotEmpty String id);

}