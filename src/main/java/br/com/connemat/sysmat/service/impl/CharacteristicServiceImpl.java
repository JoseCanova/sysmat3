package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Characteristic;
import br.com.connemat.sysmat.repository.CharacteristicRepository;
import br.com.connemat.sysmat.service.CharacteristicBaseService;

@Service
@Validated
public class CharacteristicServiceImpl 
extends BaseServiceImpl<Characteristic , Long , CharacteristicRepository>
implements CharacteristicBaseService{

	public CharacteristicServiceImpl(@Autowired CharacteristicRepository rep) {
		super(rep);
	}


	public void copyProperties(Characteristic characteristic, Characteristic c) {
		c.setLongAbbreviation(characteristic.getLongAbbreviation());
		c.setShortAbbreviation(characteristic.getShortAbbreviation());
		c.setCharacteristic(characteristic.getCharacteristic());
	}

}
