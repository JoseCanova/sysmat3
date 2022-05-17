package br.com.connemat.sysmat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.sysmat.model.entity.NameValueEntity;
import br.com.connemat.sysmat.repository.NameValueRepository;

@Service
public class NameValueService {

	@Autowired
	private NameValueRepository repository;
	
	public NameValueService() {
	}

	@Transactional("tenant-tm")
	public Page<NameValueEntity> findAll(Integer pageSize, Integer count) {
		return repository.findAll(pageSize, count);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> S save(S entity) {
		return repository.save(entity);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	@Transactional("tenant-tm")
	public Page<NameValueEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional("tenant-tm")
	public List<NameValueEntity> findAll() {
		return repository.findAll();
	}

	@Transactional("tenant-tm")
	public List<NameValueEntity> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Transactional("tenant-tm")
	public List<NameValueEntity> findAllById(Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Transactional("tenant-tm")
	public Optional<NameValueEntity> findById(String id) {
		return repository.findById(id);
	}

	@Transactional("tenant-tm")
	public void flush() {
		repository.flush();
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Transactional("tenant-tm")
	public boolean existsById(String id) {
		return repository.existsById(id);
	}

	@Transactional("tenant-tm")
	public void deleteInBatch(Iterable<NameValueEntity> entities) {
		repository.deleteInBatch(entities);
	}
	
	@Transactional("tenant-tm")
	public <S extends NameValueEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	@Transactional("tenant-tm")
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Transactional("tenant-tm")
	public NameValueEntity getOne(String id) {
		return repository.getOne(id);
	}
	
	@Transactional("tenant-tm")
	public <S extends NameValueEntity> long count(Example<S> example) {
		return repository.count(example);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	
	@Transactional("tenant-tm")
	public long count() {
		return repository.count();
	}

	@Transactional("tenant-tm")
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Transactional("tenant-tm")
	public <S extends NameValueEntity> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	@Transactional("tenant-tm")
	public void delete(NameValueEntity entity) {
		repository.delete(entity);
	}

	@Transactional("tenant-tm")
	public void deleteAll(Iterable<? extends NameValueEntity> entities) {
		repository.deleteAll(entities);
	}

	@Transactional("tenant-tm")
	public void deleteAll() {
		repository.deleteAll();
	}

}
