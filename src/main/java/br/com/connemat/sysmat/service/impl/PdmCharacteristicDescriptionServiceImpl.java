package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmCharacteristic;
import br.com.connemat.sysmat.model.entity.PdmCharacteristicDescription;
import br.com.connemat.sysmat.repository.PdmCharacteristicDescriptionRepository;
import br.com.connemat.sysmat.service.PdmCharacteristicBaseService;
import br.com.connemat.sysmat.service.PdmCharacteristicDescriptionBaseService;

@Service
@Validated
public class PdmCharacteristicDescriptionServiceImpl
extends BaseServiceImpl<PdmCharacteristicDescription,Long,PdmCharacteristicDescriptionRepository>
implements PdmCharacteristicDescriptionBaseService{

	@Autowired
	private PdmCharacteristicBaseService pdmCharacteristicService;
	
	public PdmCharacteristicDescriptionServiceImpl(@Autowired PdmCharacteristicDescriptionRepository rep) {
		super(rep);
	}


	public void prepare(PdmCharacteristicDescription pdmCharacteristicDescription) {
		Long pdChId = pdmCharacteristicDescription.getPdmCharacteristic().getId();
		PdmCharacteristic ch = pdmCharacteristicService.findByEntityId(pdChId);
		pdmCharacteristicDescription.setPdmCharacteristic(ch);
	}


	public void copyProperties(PdmCharacteristicDescription pdmCharacteristicDescription,
			PdmCharacteristicDescription pd) {
		pd.setLocale(pdmCharacteristicDescription.getLocale());
		pd.setLongAbbreviation(pdmCharacteristicDescription.getLongAbbreviation());
		pd.setShortAbbreviation(pdmCharacteristicDescription.getShortAbbreviation());
		pd.setCharacteristic(pdmCharacteristicDescription.getCharacteristic());
		pd.setPdmCharacteristic(pdmCharacteristicDescription.getPdmCharacteristic());
	}

}