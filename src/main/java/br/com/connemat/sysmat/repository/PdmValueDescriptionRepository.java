package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmValueDescription;

public interface PdmValueDescriptionRepository extends EntityRepository<PdmValueDescription, Long> {
	
	@Query(value = "from PdmValueDescription descr where descr.pdmValue.id = :id")
	List<PdmValueDescription> findByPdmValueId(@Param(value="id") Long pdmValueId);

}
