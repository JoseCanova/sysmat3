package br.com.connemat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.Base;
import br.com.connemat.EntityRepository;
import br.com.connemat.model.api.AttributeValue;
import br.com.connemat.util.EntityExceptionSupplierFactory;

public abstract class ConnematBaseService 
<T extends Base<ID> , ID , R extends EntityRepository<T, ID>> 
extends SearchServiceImpl<T,R>
{

	@Autowired
	protected EntityExceptionSupplierFactory exceptionSupplierFactory;

	@Transactional
	public List<T> findAll(Integer pageSize, Integer count) {
		return repository.findAll(pageSize, count).getContent();
	}

	@Transactional
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	@Transactional
	public <S extends T> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	@Transactional
	public List<T> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}

	@Transactional
	public List<T> findAll() {
		return repository.findAll();
	}

	@Transactional
	public List<T> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Transactional
	public List<T> findAllById(Iterable<ID> ids) {
		return repository.findAllById(ids);
	}

	@Transactional
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Transactional
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	@Transactional
	public void flush() {
		repository.flush();
	}

	@Transactional
	public <S extends T> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Transactional
	public boolean existsById(ID id) {
		return repository.existsById(id);
	}

	@Transactional
	public void deleteInBatch(Iterable<T> entities) {
		repository.deleteInBatch(entities);
	}

	@Transactional
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	@Transactional
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Transactional
	public T getOne(ID id) {
		return repository.getOne(id);
	}

	@Transactional
	public <S extends T> long count(Example<S> example) {
		return repository.count(example);
	}

	@Transactional
	public <S extends T> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	@Transactional
	public <S extends T> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	@Transactional
	public long count() {
		return repository.count();
	}

	@Transactional
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	@Transactional
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	@Transactional
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Transactional
	public void deleteAll(Iterable<? extends T> entities) {
		repository.deleteAll(entities);
	}

	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}

	@Transactional
	public 	AttributeValue<?> getLazyAttribute(ID id, String attributeName) {
		AttributeValue<?> value = repository
				.findById(id)
				.map(instance ->{
					BeanWrapper bw = new BeanWrapperImpl(instance);
					return new AttributeValue<>(bw.getPropertyValue(attributeName));	
				}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
		return value;
	}


	@Transactional
	public T findByEntityIdFetchProperty(ID id , String attributeName)
	{
		return findById(id)
				.map(entity -> {
					BeanWrapper bw = new BeanWrapperImpl(entity);
					Object o =  bw.getPropertyValue(attributeName);	
					bw.setPropertyValue(attributeName, o);
					return entity;})
				.orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

}