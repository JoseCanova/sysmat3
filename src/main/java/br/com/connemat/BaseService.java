package br.com.connemat;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.model.api.SearchContainer;

public interface BaseService<T extends Base<ID>, ID extends Serializable> {

	@Transactional
	List<T> findByEntityUsingExample(SearchContainer<T> entity , Integer start , Integer size);
	
	@Transactional
	List<T> findAll(Integer pageSize, Integer count);
	
	@Transactional
	List<T> findAll(Pageable sort);
	
	@Transactional
	void deleteAll(Iterable<? extends T> entities);
	
	@Transactional
	<S extends T> List<S> saveAll(Iterable<S> entities);
	
	@Transactional
	T addEntity(@Valid @NotNull(groups={CreateValidationGroup.class}) T  entity);
	
	@Transactional
	T updateEntity(@Valid @NotNull(groups={UpdateValidationGroup.class})  ID id , @Valid @NotNull(groups={UpdateValidationGroup.class})  T entity);
	
	@Transactional
	Object deleteEntity(@Valid @NotNull ID id);
	
	@Transactional
	T findByEntityId(@Valid @NotNull ID id);

	@Transactional
	T findByEntityIdFetchProperty(ID id , String property);
	
}
