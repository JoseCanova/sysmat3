package br.com.connemat;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.Sector;

@Validated
public interface SectorBaseService 
extends CrudBaseService<Sector,Long>{
}