package br.com.connemat.spring.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.NcmTree;

public interface NcmTreeRepository extends EntityRepository<NcmTree, Long> {
	
	@Query(value="from NcmTree nt where nt.parent.id = :id")
	List<NcmTree> findNcmsByParentId(@Param(value="id") Long parentId);
	
	Optional<NcmTree> findNcmTreeByCode(String code);
	
}
