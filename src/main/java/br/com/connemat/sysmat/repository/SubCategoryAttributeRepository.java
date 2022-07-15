package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.SubCategoryAttribute;

public interface SubCategoryAttributeRepository extends EntityRepository<SubCategoryAttribute, Long> {

	@Query(value="from SubCategoryAttribute att where att.subCategory.id = :id")
	List<SubCategoryAttribute> findSubCategoryAttributeBySubCategoryId(@Param(value="id") Long id);
	
}
