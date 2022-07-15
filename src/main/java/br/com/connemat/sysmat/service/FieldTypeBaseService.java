package br.com.connemat.sysmat.service;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.FieldType;
import br.com.connemat.sysmat.model.entity.util.FieldTypeEnum;

@Validated
public interface FieldTypeBaseService 
extends CrudBaseService<FieldType  ,  FieldTypeEnum> {

}