package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.CustomValue;

public interface CustomValueRepository extends EntityRepository<CustomValue, Long>{
	
	@Query(value="from CustomValue cv inner join cv.parentCustomValues pcv where pcv.id = :id")
	List<CustomValue> findCustomValuesByParentCustomValueId(@Param(value="id") Long id );
}
