package br.com.connemat.sysmat.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Unit;
import br.com.connemat.sysmat.repository.UnitRepository;
import br.com.connemat.sysmat.service.UnitBaseService;

@Service
@Validated
@Qualifier(value="unitBaseService")
@Primary
public class UnitServiceImpl  
extends BaseServiceImpl<Unit , Long , UnitRepository>
implements UnitBaseService{

	
	public UnitServiceImpl(@Autowired  UnitRepository repository) {
		super(repository);
	}


	@Override
	public Object deactivateUnit(@Valid  @NotNull Long id) {
		return findById(id)
		.map(u -> {
			u.setDisabled(true);
			return save(u);
		}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}


}
