package br.com.connemat.sysmat.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmValue;

public interface PdmValueRepository extends EntityRepository<PdmValue, Long> {

	@Override
	@Modifying
	@EntityGraph(value = "PdmValue.descriptions")
	Page<PdmValue> findAll(Pageable pageable);

	@Override
	@Modifying
	@EntityGraph(value = "PdmValue.descriptions")
	<S extends PdmValue> Page<S> findAll(Example<S> example, Pageable pageable);

	@Override
	@Modifying
	@EntityGraph(value = "PdmValue.descriptions")
	Optional<PdmValue> findById(Long id);
	
}
