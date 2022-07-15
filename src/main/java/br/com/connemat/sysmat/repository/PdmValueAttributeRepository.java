package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmValueAttribute;

public interface PdmValueAttributeRepository extends EntityRepository<PdmValueAttribute, Long>{
	
	
	@Query(value = "from PdmValueAttribute pda  where pda.pdmValue.id = :id")
	List<PdmValueAttribute> findByPdmValueId(@Param(value = "id")  Long id);

}
