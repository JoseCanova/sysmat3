package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Characteristic;
import br.com.connemat.sysmat.model.entity.CharacteristicAttribute;
import br.com.connemat.sysmat.repository.CharacteristicAttributeRepository;
import br.com.connemat.sysmat.service.CharacteristicAttributeBaseService;
import br.com.connemat.sysmat.service.CharacteristicBaseService;

@Service
@Validated
public class CharacteristicAttributeServiceImpl 
extends BaseServiceImpl<CharacteristicAttribute , Long , CharacteristicAttributeRepository>
implements CharacteristicAttributeBaseService{

	@Autowired
	private CharacteristicBaseService characteristicService;
	
	public CharacteristicAttributeServiceImpl(@Autowired CharacteristicAttributeRepository rep) {
		super (rep);
	}


	public void prepare(
			CharacteristicAttribute characteristicAttribute) {
		Long chId = characteristicAttribute.getCharacteristic().getId();
		Characteristic ch = characteristicService.findByEntityId(chId);
		characteristicAttribute.setCharacteristic(ch);
	}

	public void copyProperties(
			CharacteristicAttribute characteristicAttribute,
			CharacteristicAttribute ca) {
		ca.setAttributeId(characteristicAttribute.getAttributeId());
		ca.setAttributeValue(characteristicAttribute.getAttributeValue());
		ca.setCharacteristic(characteristicAttribute.getCharacteristic());
	}

}
