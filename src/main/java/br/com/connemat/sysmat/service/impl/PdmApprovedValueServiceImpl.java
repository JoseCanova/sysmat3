package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmApprovedValue;
import br.com.connemat.sysmat.model.entity.PdmCharacteristic;
import br.com.connemat.sysmat.model.entity.PdmValue;
import br.com.connemat.sysmat.repository.PdmApprovedValueRepository;
import br.com.connemat.sysmat.service.PdmApprovedValueBaseService;
import br.com.connemat.sysmat.service.PdmCharacteristicBaseService;
import br.com.connemat.sysmat.service.PdmValueBaseService;

@Service
@Validated
public class PdmApprovedValueServiceImpl 
extends BaseServiceImpl<PdmApprovedValue,Long,PdmApprovedValueRepository>
implements PdmApprovedValueBaseService{

	@Autowired
	private PdmValueBaseService pdmValueService;

	@Autowired
	private PdmCharacteristicBaseService pdmCharacteristicService;
	
	public PdmApprovedValueServiceImpl(@Autowired PdmApprovedValueRepository rep) {
		super(rep);
	}


	
	public void prepare(PdmApprovedValue pdmApprovedValue) {
		Long pdmValueId =   pdmApprovedValue.getPdmValue().getId();
		Long chId = pdmApprovedValue.getPdmCharacteristic().getId();
		PdmValue pdmValue = pdmValueService.findByEntityId(pdmValueId);
		PdmCharacteristic pdmc = pdmCharacteristicService.findByEntityId(chId);
		pdmApprovedValue.setPdmValue(pdmValue);
		pdmApprovedValue.setPdmCharacteristic(pdmc);
	}


}