package br.com.connemat;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.SystemConfig;

@Validated
public interface SystemConfigBaseService 
extends CrudBaseService<SystemConfig, Long>{
}