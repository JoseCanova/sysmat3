package br.com.connemat.sysmat.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.Category;

public interface CategoryRepository extends EntityRepository<Category, Long> {

	@Override
	@Modifying
	@EntityGraph(value = "Category.descriptions")
	Page<Category> findAll(Pageable pageable);
	
	@Override
	@Modifying
	@EntityGraph(value = "Category.descriptions")
	Optional<Category> findById(Long id);
	
	@Override
	@Modifying
	@EntityGraph(value = "Category.descriptions")
	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);
	
}
