package br.com.connemat.sysmat.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.Unit;
import br.com.connemat.sysmat.model.entity.UnitDescription;
import br.com.connemat.sysmat.repository.UnitDescriptionRepository;
import br.com.connemat.sysmat.service.UnitBaseService;
import br.com.connemat.sysmat.service.UnitDescriptionBaseService;

@Service
@Validated
public class UnitDescritpionServiceImpl
extends BaseServiceImpl<UnitDescription , Long , UnitDescriptionRepository>
implements UnitDescriptionBaseService{

	@Autowired 
	private UnitBaseService unitService; 
		
	public UnitDescritpionServiceImpl(@Autowired UnitDescriptionRepository repository) {
		super(repository);
	}
	
	@Override
	public void prepare(UnitDescription s) {
		Unit theUnit = unitService.findByEntityId(s.getUnit().getId());
		s.setUnit(theUnit);	
	}

	public  void copyProperties(
			@Valid @NotNull(groups = UpdateValidationGroup.class) UnitDescription unitDescription,
			UnitDescription ud) {
		ud.setLocale(unitDescription.getLocale());
		ud.setDescription(unitDescription.getDescription());
	}


}
