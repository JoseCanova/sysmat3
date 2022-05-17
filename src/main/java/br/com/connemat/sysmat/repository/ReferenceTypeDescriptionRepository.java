package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.ReferenceTypeDescription;

public interface ReferenceTypeDescriptionRepository extends EntityRepository<ReferenceTypeDescription, Long> {
	
	@Query(value="from ReferenceTypeDescription descr where descr.referenceType.id = :id")
	List<ReferenceTypeDescription> findByReferenceTypeDescriptionsByReferenceTypeId(
			@Param(value="id") String id);
	
}
