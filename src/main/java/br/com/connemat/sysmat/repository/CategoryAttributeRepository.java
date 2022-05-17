package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.CategoryAttribute;

public interface CategoryAttributeRepository extends EntityRepository<CategoryAttribute, Long> {
	
	
	@Query(value="from CategoryAttribute att where att.category.id = :id")
	List<CategoryAttribute> findCategoryAttributeByCategoryId(@Param(value="id") Long id);
	
}