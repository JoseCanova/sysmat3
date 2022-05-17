package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.PdmApprovedValueAttribute;

public interface PdmApprovedValueAttributeRepository 
extends EntityRepository<PdmApprovedValueAttribute, Long> {

	@Query(value="from PdmApprovedValueAttribute pav where pav.pdmApprovedValue.id = :id")
	List<PdmApprovedValueAttribute> findByPdmApprovedValueId(@Param(value = "id") Long id);

}
