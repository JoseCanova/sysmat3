package br.com.connemat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.ServiceFiscalCodeBaseService;
import br.com.connemat.ServiceFiscalCodeTreeBaseService;
import br.com.connemat.model.entity.ServiceFiscalCode;
import br.com.connemat.spring.data.repository.ServiceFiscalCodeRepository;

@Service
@Validated
public class ServiceFiscalCodeBaseServiceImpl
extends ConnematBaseService<ServiceFiscalCode, String, ServiceFiscalCodeRepository>
implements ServiceFiscalCodeBaseService {

	@Autowired
	private ServiceFiscalCodeTreeBaseService serviceFiscalCodeTreeService;
	
	@Override
	public void prepare(ServiceFiscalCode s) {
		Long treeId = s.getServiceFiscalCodeTree().getId();
		s.setServiceFiscalCodeTree(serviceFiscalCodeTreeService.findByEntityId(treeId));
	}
	
	public void copyProperties(
			ServiceFiscalCode theCode,
			ServiceFiscalCode sfc) {
			sfc.setDescription(theCode.getDescription());
			sfc.setId(theCode.getId());
			sfc.setStartDate(theCode.getStartDate());
			sfc.setEndDate(theCode.getEndDate());
			sfc.setServiceFiscalCodeTree(theCode.getServiceFiscalCodeTree());
	}

}