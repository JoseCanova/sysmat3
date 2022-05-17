package br.com.connemat.sysmat.service.impl;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Manufacturer;
import br.com.connemat.sysmat.repository.ManufacturerRepository;
import br.com.connemat.sysmat.service.ManufacturerBaseService;

@Service
@Validated
public class ManufacturerServiceImpl 
extends BaseServiceImpl <Manufacturer ,  Long , ManufacturerRepository>
implements ManufacturerBaseService {

	public ManufacturerServiceImpl(@Autowired  ManufacturerRepository repository) {
		super(repository);
	}

	@Override
	public Object deactivateManufacturer(@Valid  @NotNull Long id) {
		Optional<Manufacturer>opt = findById(id);
		return opt
				.map(man ->{
					man.setDisabled(true);
					save(man);
					return true;
				}).orElseThrow();
	}
}
