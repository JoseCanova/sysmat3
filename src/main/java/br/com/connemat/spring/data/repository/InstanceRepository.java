package br.com.connemat.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.Instance;

public interface InstanceRepository extends EntityRepository<Instance,Long>{

	@Query(value=" from Instance i where i.sector.id = :id")
	List<Instance> findIntanceBySectorId(@Param(value = "id") Long sectorId);

}
