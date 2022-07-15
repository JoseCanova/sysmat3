package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Characteristic;
import br.com.connemat.sysmat.model.entity.Pdm;
import br.com.connemat.sysmat.model.entity.PdmCharacteristic;
import br.com.connemat.sysmat.repository.PdmCharacteristicRepository;
import br.com.connemat.sysmat.service.CharacteristicBaseService;
import br.com.connemat.sysmat.service.PdmBaseService;
import br.com.connemat.sysmat.service.PdmCharacteristicBaseService;


@Service
@Validated
public class PdmCharacteristicServiceImpl 
extends BaseServiceImpl<PdmCharacteristic,Long , PdmCharacteristicRepository>
implements PdmCharacteristicBaseService {

	@Autowired
	private PdmBaseService pdmBaseService;
	
	@Autowired
	private CharacteristicBaseService characteristicService;
	
	public PdmCharacteristicServiceImpl(@Autowired PdmCharacteristicRepository rep) {
		super(rep);
	}

	public void prepare(PdmCharacteristic pdmCharacteristic) {
		Pdm pdm = pdmBaseService.findByEntityId(pdmCharacteristic.getPdm().getId());
		pdmCharacteristic.setPdm(pdm);
		Characteristic c = characteristicService
								.findByEntityId(pdmCharacteristic.getCharacteristic().getId());
		pdmCharacteristic.setCharacteristic(c);
	}


	public void copyProperties(
			PdmCharacteristic pdmCharacteristic,
			PdmCharacteristic pc) {
		pc.setLongAbbbreviation(pdmCharacteristic.getLongAbbbreviation());
		pc.setShortAbbreviation(pdmCharacteristic.getShortAbbreviation());
		pc.setShowIn(pdmCharacteristic.getShowIn());
		pc.setPriority(pdmCharacteristic.getPriority());
		pc.setOrder(pdmCharacteristic.getOrder());
		pc.setRequired(pdmCharacteristic.getRequired());
	}

}
