package br.com.connemat;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.App;

@Validated
public interface AppBaseService 
extends CrudBaseService<App,String>{
}
