package br.com.connemat.sysmat.service;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.ReferenceType;

@Validated
public interface ReferenceTypeBaseService extends 
CrudBaseService<ReferenceType,String>{
}