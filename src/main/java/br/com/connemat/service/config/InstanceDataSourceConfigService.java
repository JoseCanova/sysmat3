package br.com.connemat.service.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.connemat.model.entity.InstanceDataSourceConfig;
import br.com.connemat.spring.data.repository.InstanceConfigDataSourceRepository;

@Service
public class InstanceDataSourceConfigService {

	@Autowired
	private InstanceConfigDataSourceRepository repository;

	public Page<InstanceDataSourceConfig> findAll(Integer pageSize, Integer count) {
		return repository.findAll(pageSize, count);
	}

	public <S extends InstanceDataSourceConfig> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends InstanceDataSourceConfig> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<InstanceDataSourceConfig> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<InstanceDataSourceConfig> findAll() {
		return repository.findAll();
	}

	public List<InstanceDataSourceConfig> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<InstanceDataSourceConfig> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends InstanceDataSourceConfig> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<InstanceDataSourceConfig> findById(Long id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends InstanceDataSourceConfig> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<InstanceDataSourceConfig> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends InstanceDataSourceConfig> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public InstanceDataSourceConfig getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends InstanceDataSourceConfig> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends InstanceDataSourceConfig> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends InstanceDataSourceConfig> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends InstanceDataSourceConfig> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(InstanceDataSourceConfig entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends InstanceDataSourceConfig> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
}
