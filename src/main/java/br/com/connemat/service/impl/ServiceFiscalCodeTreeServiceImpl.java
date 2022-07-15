package br.com.connemat.service.impl;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.ServiceFiscalCodeTreeBaseService;
import br.com.connemat.model.entity.ServiceFiscalCodeTree;
import br.com.connemat.spring.data.repository.ServiceFiscalCodeTreeRepository;

@Service
@Validated
public class ServiceFiscalCodeTreeServiceImpl
extends ConnematBaseService<ServiceFiscalCodeTree, Long, ServiceFiscalCodeTreeRepository>
implements ServiceFiscalCodeTreeBaseService {

	public ServiceFiscalCodeTreeServiceImpl(@Autowired ServiceFiscalCodeTreeRepository theRep) {
		this.repository=theRep;
	}

	public void copyProperties(
			ServiceFiscalCodeTree theTree,
			ServiceFiscalCodeTree st) {
		st.setCode(theTree.getCode());
		st.setDescription(theTree.getDescription());
	}


	@Override
	public Optional<ServiceFiscalCodeTree> findServiceFiscalTreeByCode(@Valid @NotEmpty String code) {
		return repository.findServiceFiscalTreeByCode(code);
	}

}
