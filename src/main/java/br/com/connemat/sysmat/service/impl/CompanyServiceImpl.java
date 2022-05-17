package br.com.connemat.sysmat.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.connemat.sysmat.model.entity.Company;
import br.com.connemat.sysmat.repository.CompanyRepository;
import br.com.connemat.sysmat.service.CompanyBaseService;

@Service
public class CompanyServiceImpl 
extends BaseServiceImpl<Company , Long , CompanyRepository> 
implements CompanyBaseService{
	
	public CompanyServiceImpl(@Autowired CompanyRepository repository) {
		super(repository);
	}

	@Override
	public Object deactivatedCompany(@Valid @NotNull Long id) {
		return findById(id)
				.filter(c -> c.getDisabled()==false)
				.map(c ->{
					c.setDisabled(true);
					return save(c);
		})
		.orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}
}
