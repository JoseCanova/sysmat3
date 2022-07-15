package br.com.connemat;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.api.AttributeValue;

@Validated
public interface LazyAttributeBaseService<T extends Base<ID> , ID extends Serializable>
extends CrudBaseService<T,ID> {

	AttributeValue<?> getLobAttribute(@Valid @NotNull ID id, String attributeName);
	
}
