package br.com.connemat.sysmat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.SubCategory;

public interface SubCategoryRepository extends EntityRepository<SubCategory, Long> {
	
	@Query(value="from SubCategory sub where sub.category.id=:id")
	List<SubCategory> findSubCategoryByCatagoryId(@Param(value="id") Long id);

	@Override
	@Modifying
	@EntityGraph(value = "SubCategory.descriptions")
	Page<SubCategory> findAll(Pageable pageable);

	@Override
	@Modifying
	@EntityGraph(value = "SubCategory.descriptions")
	<S extends SubCategory> Page<S> findAll(Example<S> example, Pageable pageable);

	@Override
	@Modifying
	@EntityGraph(value = "SubCategory.descriptions")
	Optional<SubCategory> findById(Long id);


}
