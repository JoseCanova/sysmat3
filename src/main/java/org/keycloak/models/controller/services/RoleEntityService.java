package org.keycloak.models.controller.services;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.RoleEntity;
import org.keycloak.models.repository.RoleEntityRepository;
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
public class RoleEntityService {

	@Autowired
	private RoleEntityRepository repository;

	public List<RoleEntity> getSysmatActionRoles() {
		return repository.getSysmatActionRoles();
	}

	public <S extends RoleEntity> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends RoleEntity> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<RoleEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<RoleEntity> findAll() {
		return repository.findAll();
	}

	public List<RoleEntity> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<RoleEntity> findAllById(Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	public <S extends RoleEntity> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<RoleEntity> findById(String id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends RoleEntity> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(String id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<RoleEntity> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends RoleEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public RoleEntity getOne(String id) {
		return repository.getOne(id);
	}

	public <S extends RoleEntity> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends RoleEntity> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends RoleEntity> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public <S extends RoleEntity> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(RoleEntity entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends RoleEntity> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
}
