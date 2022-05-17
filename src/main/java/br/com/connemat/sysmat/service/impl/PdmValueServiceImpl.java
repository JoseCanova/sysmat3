package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmValue;
import br.com.connemat.sysmat.repository.PdmValueRepository;
import br.com.connemat.sysmat.service.PdmValueBaseService;

@Service
@Validated
public class PdmValueServiceImpl 
extends BaseServiceImpl<PdmValue, Long , PdmValueRepository> 
implements PdmValueBaseService {

	public PdmValueServiceImpl(@Autowired PdmValueRepository repository) {
		super(repository);
	}

	public void copyProperties(PdmValue pdmValue,
			PdmValue pdm) {
		pdm.setComments(pdmValue.getComments());
		pdm.setPdmValue(pdmValue.getPdmValue());
	}

}
