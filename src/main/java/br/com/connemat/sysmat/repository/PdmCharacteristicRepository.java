package br.com.connemat.sysmat.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmCharacteristic;

public interface PdmCharacteristicRepository extends EntityRepository<PdmCharacteristic, Long> {
	
	@Override
	@Modifying
	@EntityGraph(value = "PdmCharacteristic.descriptions")
	Page<PdmCharacteristic> findAll(Pageable pageable);
	
	@Override
	@Modifying
	@EntityGraph(value = "PdmCharacteristic.descriptions")
	Optional<PdmCharacteristic> findById(Long id);
	
	@Override
	@Modifying
	@EntityGraph(value = "PdmCharacteristic.descriptions")
	<S extends PdmCharacteristic> Page<S> findAll(Example<S> example, Pageable pageable);
	
	
}