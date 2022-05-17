package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmCharacteristic;
import br.com.connemat.sysmat.model.entity.PdmCharacteristicAttribute;
import br.com.connemat.sysmat.repository.PdmCharacteristicAttributeRepository;
import br.com.connemat.sysmat.service.PdmCharacteristicAttributeBaseService;
import br.com.connemat.sysmat.service.PdmCharacteristicBaseService;

@Service
@Primary
@Validated
public class PdmCharacteristicAttributeServiceImpl
extends BaseServiceImpl<PdmCharacteristicAttribute  , Long , PdmCharacteristicAttributeRepository>
implements PdmCharacteristicAttributeBaseService{

	@Autowired
	private PdmCharacteristicBaseService pdmCharacteristicService;
	
	public PdmCharacteristicAttributeServiceImpl(@Autowired PdmCharacteristicAttributeRepository rep) {
		super(rep);
	}


	public void prepare(PdmCharacteristicAttribute pdmCharacteristicAttribute) {
		Long chId = pdmCharacteristicAttribute.getPdmCharacteristic().getId();
		PdmCharacteristic pdmc = pdmCharacteristicService.findByEntityId(chId);
		pdmCharacteristicAttribute.setPdmCharacteristic(pdmc);
	}

	@Override
	@Transactional("tenant-tm")
	public List<PdmCharacteristicAttribute> findByPdmCharacteristicId(@Valid @NotNull Long id) {
		return repository.findByPdmCharacteristicId(id);
	}

}