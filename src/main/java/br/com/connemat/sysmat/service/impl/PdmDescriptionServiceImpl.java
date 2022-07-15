package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Pdm;
import br.com.connemat.sysmat.model.entity.PdmDescription;
import br.com.connemat.sysmat.repository.PdmDescriptionRepository;
import br.com.connemat.sysmat.service.PdmBaseService;
import br.com.connemat.sysmat.service.PdmDescriptionBaseService;

@Service
@Validated
public class PdmDescriptionServiceImpl 
extends BaseServiceImpl<PdmDescription , Long , PdmDescriptionRepository>
implements PdmDescriptionBaseService{

	@Autowired
	private PdmBaseService pdmService;
	
	public PdmDescriptionServiceImpl(@Autowired  PdmDescriptionRepository rep) {
		super(rep);
	}

	
	public void prepare(PdmDescription pdmDesciption) {
		Long pdmId = pdmDesciption.getPdm().getId();
		Pdm pdm = pdmService.findByEntityId(pdmId);
		pdmDesciption.setPdm(pdm);
	}


	public void copyProperties(PdmDescription pdmDescription, PdmDescription pd) {
		pd.setLocale(pdmDescription.getLocale());
		pd.setShortAbbbreviation(pdmDescription.getShortAbbbreviation());
		pd.setLongAbbbreviation(pdmDescription.getLongAbbbreviation());
		pd.setPdmName(pdmDescription.getPdmName());
	}

}
