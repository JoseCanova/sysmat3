package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.CharacteristicDescription;

public interface CharacteristicDescriptionRepository 
extends EntityRepository<CharacteristicDescription, Long> {

	
	@Query(value="from CharacteristicDescription cd where cd.characteristic.id = :id")
	List<CharacteristicDescription> findByCharacteristicId(@Param(value = "id")  Long id);
	
}
