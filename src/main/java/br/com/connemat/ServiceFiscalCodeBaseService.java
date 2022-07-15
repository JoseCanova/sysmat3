package br.com.connemat;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.ServiceFiscalCode;

@Validated
public interface ServiceFiscalCodeBaseService 
extends CrudBaseService<ServiceFiscalCode,String> {
}
