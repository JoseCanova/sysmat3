package br.com.connemat;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.Instance;

@Validated
public interface InstanceBaseService 
extends LazyAttributeBaseService<Instance, Long>{

	Instance updateInstance(Long id , Instance instance);

	Instance addInstance(Instance instance);
	
	Object deleteInstance(Long id);
	
	Instance activateInstance(@Valid @NotNull Instance instance);
	
	List<Instance> findIntanceBySectorId(@Valid @NotNull Long sectorId);

	@Override
	default Instance updateEntity(@Valid @NotNull(groups = UpdateValidationGroup.class) Long id,
			@Valid @NotNull(groups = UpdateValidationGroup.class) Instance entity) {
		return updateInstance(id, entity);
	}
	
	@Override
	default Instance addEntity(@Valid @NotNull(groups = CreateValidationGroup.class) Instance entity) {
		return addInstance(entity);
	}
	
	@Override
	default Object deleteEntity(@Valid @NotNull Long id) {
		return deleteInstance(id);
	}
}