package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.CategoryDescription;

public interface CategoryDescriptionRepository extends EntityRepository<CategoryDescription, Long> {
	
	@Query(value="from CategoryDescription descr where descr.category.id = :id")
	List<CategoryDescription> findCategoryDescriptionByCategoryId(@Param(value="id") Long id);
	
}
