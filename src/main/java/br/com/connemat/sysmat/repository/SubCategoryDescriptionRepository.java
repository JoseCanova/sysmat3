package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.SubCategoryDescription;

public interface SubCategoryDescriptionRepository extends EntityRepository<SubCategoryDescription, Long> {

	
	@Query(value="from SubCategoryDescription descr where descr.subCategory.id = :id")
	List<SubCategoryDescription> findSubCategoryByCategoryId(@Param(value="id") Long id);

}
