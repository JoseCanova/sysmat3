package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmCharacteristicAttribute;

public interface PdmCharacteristicAttributeRepository 
extends EntityRepository<PdmCharacteristicAttribute,Long> {

	@Query(value="from PdmCharacteristicAttribute pca where pca.pdmCharacteristic.id = :id")
	List<PdmCharacteristicAttribute>  findByPdmCharacteristicId(@Param(value = "id") Long id);

}
