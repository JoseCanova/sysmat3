package br.com.connemat.spring.data.repository;

import java.util.List;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.InstanceDataSourceConfig;

public interface InstanceDataSourceConfigRepository extends EntityRepository<InstanceDataSourceConfig, Long> {

	List<InstanceDataSourceConfig> findByAppId(Long id);
	
	List<InstanceDataSourceConfig> findByInstanceId(Long id);
	
}
