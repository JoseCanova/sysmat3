package br.com.connemat;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.ServiceFiscalCodeTree;

@Validated
public interface ServiceFiscalCodeTreeBaseService extends 
CrudBaseService<ServiceFiscalCodeTree,Long> {

	Optional<ServiceFiscalCodeTree> findServiceFiscalTreeByCode(@Valid @NotEmpty String code);

}
