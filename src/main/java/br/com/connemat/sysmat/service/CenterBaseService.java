package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.Center;
import br.com.connemat.sysmat.model.entity.validation.DeactivationValidationGroup;

@Validated
public interface CenterBaseService extends 
CrudBaseService<Center,Long>{
	
	@Validated(value= {UpdateValidationGroup.class})
	Object deactivateCenter(@Valid @NotNull Long id);

	
	List<Center> findCenterByCompanyId(@Valid @NotNull Long id);
	
	@Validated(value= {DeactivationValidationGroup.class})
	default Center validateDeactivation(@Valid @NotNull Center c) {
		return c;
	}
}
