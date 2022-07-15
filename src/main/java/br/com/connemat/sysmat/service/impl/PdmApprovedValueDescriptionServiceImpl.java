package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmApprovedValue;
import br.com.connemat.sysmat.model.entity.PdmApprovedValueDescription;
import br.com.connemat.sysmat.repository.PdmApprovedValueDescriptionRepository;
import br.com.connemat.sysmat.service.PdmApprovedValueBaseService;
import br.com.connemat.sysmat.service.PdmApprovedValueDescriptionBaseService;

@Service
@Validated
public class PdmApprovedValueDescriptionServiceImpl 
extends BaseServiceImpl<PdmApprovedValueDescription, Long , PdmApprovedValueDescriptionRepository> 
implements PdmApprovedValueDescriptionBaseService{

	@Autowired
	private PdmApprovedValueBaseService pdmApprovedValueService;
	
	
	public PdmApprovedValueDescriptionServiceImpl(@Autowired PdmApprovedValueDescriptionRepository serv) {
		super(serv);
	}


	public void prepare(PdmApprovedValueDescription pdmApprovedValueDescription) {
		Long pvId = pdmApprovedValueDescription.getPdmApprovedValue().getId();
		PdmApprovedValue pdmApprovedValue = pdmApprovedValueService.findByEntityId(pvId);
		pdmApprovedValueDescription.setPdmApprovedValue(pdmApprovedValue);
	}


	public void copyProperties(PdmApprovedValueDescription pdmApprovedValueDescription, PdmApprovedValueDescription pd) {
		pd.setLocale(pdmApprovedValueDescription.getLocale());
		pd.setLongAbbreviation(pdmApprovedValueDescription.getLongAbbreviation());
		pd.setShortAbbreviation(pdmApprovedValueDescription.getShortAbbreviation());
		pd.setPdmValue(pdmApprovedValueDescription.getPdmValue());
		pd.setPdmApprovedValue(pdmApprovedValueDescription.getPdmApprovedValue());
	}

}
