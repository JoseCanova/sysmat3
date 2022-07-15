package org.keycloak.models.controller.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.keycloak.models.jpa.entities.RequiredActionProviderEntity;
import org.keycloak.models.repository.RequiredActionProviderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Profile(value = "keycloak")
public class RequiredActionProviderEntityService {

	@Autowired
	private RequiredActionProviderEntityRepository repository;
	
	public RequiredActionProviderEntityService() {
	}

	public <S extends RequiredActionProviderEntity> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends RequiredActionProviderEntity> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<RequiredActionProviderEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<RequiredActionProviderEntity> findAll() {
		return repository.findAll();
	}

	public List<RequiredActionProviderEntity> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<RequiredActionProviderEntity> findAllById(Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	public <S extends RequiredActionProviderEntity> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<RequiredActionProviderEntity> findById(String id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends RequiredActionProviderEntity> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(String id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<RequiredActionProviderEntity> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends RequiredActionProviderEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public RequiredActionProviderEntity getOne(String id) {
		return repository.getOne(id);
	}

	public <S extends RequiredActionProviderEntity> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends RequiredActionProviderEntity> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends RequiredActionProviderEntity> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public <S extends RequiredActionProviderEntity> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(RequiredActionProviderEntity entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends RequiredActionProviderEntity> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
	public List<RequiredActionProviderEntity> getAvailableRequiredActions(@NotNull String realm){
		return repository.getRealmRequiredActions(realm);
	}
	
}
