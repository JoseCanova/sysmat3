package org.keycloak.models.controller.services;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.RealmEntity;
import org.keycloak.models.repository.RealmEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "keycloak")
public class RealmEntityService {

	@Autowired
	public RealmEntityRepository repository;
	
	
	public <S extends RealmEntity> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends RealmEntity> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<RealmEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<RealmEntity> findAll() {
		return repository.findAll();
	}

	public List<RealmEntity> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<RealmEntity> findAllById(Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	public <S extends RealmEntity> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<RealmEntity> findById(String id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends RealmEntity> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(String id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<RealmEntity> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends RealmEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public RealmEntity getOne(String id) {
		return repository.getOne(id);
	}

	public <S extends RealmEntity> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends RealmEntity> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends RealmEntity> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public <S extends RealmEntity> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(RealmEntity entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends RealmEntity> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	
}
