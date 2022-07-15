package br.com.connemat.sysmat.service;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.UnitDescription;

@Validated
public interface UnitDescriptionBaseService extends 
CrudBaseService<UnitDescription,Long> {
}
