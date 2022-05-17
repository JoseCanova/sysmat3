package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.Characteristic;
import br.com.connemat.sysmat.model.entity.CharacteristicDescription;
import br.com.connemat.sysmat.repository.CharacteristicDescriptionRepository;
import br.com.connemat.sysmat.service.CharacteristicBaseService;
import br.com.connemat.sysmat.service.CharacteristicDescriptionBaseService;

@Service
@Validated
@Primary
public class CharacteristicDescriptionServiceImpl 
extends BaseServiceImpl<CharacteristicDescription,Long  , CharacteristicDescriptionRepository>
implements CharacteristicDescriptionBaseService{

	@Autowired
	private CharacteristicBaseService characteristicService;
	
	public CharacteristicDescriptionServiceImpl(@Autowired CharacteristicDescriptionRepository rep) {
		super(rep);
	}


	public void prepare(CharacteristicDescription characteristicDescription) {
		Long chId = characteristicDescription.getTheCharacteristic().getId();
		Characteristic ch = characteristicService.findByEntityId(chId);
		characteristicDescription.setTheCharacteristic(ch);
	}

	public void copyProperties(CharacteristicDescription characteristicDescription,
			CharacteristicDescription cd) {
		cd.setLocale(characteristicDescription.getLocale());
		cd.setLongAbbreviation(characteristicDescription.getLongAbbreviation());
		cd.setShortAbbreviation(characteristicDescription.getShortAbbreviation());
		cd.setCharacteristic(characteristicDescription.getCharacteristic());
	}

	@Override
	public List<CharacteristicDescription> findByCharacteristicId(@Valid @NotNull Long id) {
		return repository.findByCharacteristicId(id);
	}

}
