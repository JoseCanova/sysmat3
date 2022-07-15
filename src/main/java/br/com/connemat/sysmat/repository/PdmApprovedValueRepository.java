package br.com.connemat.sysmat.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmApprovedValue;

public interface PdmApprovedValueRepository extends EntityRepository<PdmApprovedValue, Long> {
	
	@Modifying
	@EntityGraph(value = "PdmApprovedValue.descriptions")
	Page<PdmApprovedValue> findAll(Pageable pageable);
	
	@Override
	@Modifying
	@EntityGraph(value = "PdmApprovedValue.descriptions")
	<S extends PdmApprovedValue> Page<S> findAll(Example<S> example, Pageable pageable);
	
	@Modifying
	@EntityGraph(value = "PdmApprovedValue.descriptions")
	Optional<PdmApprovedValue> findById(Long id);
}
