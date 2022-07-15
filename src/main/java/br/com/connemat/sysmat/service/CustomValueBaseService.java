package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.CustomValue;

@Validated
public interface CustomValueBaseService extends 
CrudBaseService<CustomValue , Long>{
	
	CustomValue addParentCustomValue(
			@Valid @NotNull(groups = UpdateValidationGroup.class) Long childId,
			@Valid @NotNull(groups = UpdateValidationGroup.class) CustomValue theParentCustomValue);
	
	CustomValue deleteParentCustomValue(
			@Valid @NotNull(groups=UpdateValidationGroup.class) Long childId, 
			@Valid @NotNull(groups = UpdateValidationGroup.class) CustomValue parentCustomValue);
	
	List<CustomValue> findCustomValuesByParentCustomValueId(@Valid @NotNull Long id);
	
}
