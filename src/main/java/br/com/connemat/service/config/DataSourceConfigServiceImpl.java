package br.com.connemat.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.DataSourceConfigBaseService;
import br.com.connemat.model.entity.DataSourceConfig;
import br.com.connemat.service.impl.ConnematBaseService;
import br.com.connemat.spring.data.repository.DataSourceConfigRepository;

@Service
@Primary
public class DataSourceConfigServiceImpl
extends ConnematBaseService<DataSourceConfig, Long, DataSourceConfigRepository> 
implements DataSourceConfigBaseService {

	public DataSourceConfigServiceImpl(@Autowired DataSourceConfigRepository rep) {
		this.repository=rep;
	}
	
	@Override
	@Transactional("connemat-tm")
	public DataSourceConfig findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public DataSourceConfig addEntity(DataSourceConfig entity) {
		return null;
	}

	@Override
	public DataSourceConfig updateEntity(Long id, DataSourceConfig entity) {
		return null;
	}

	@Override
	public Object deleteEntity(Long id) {
		return null;
	}

	@Override
	public DataSourceConfig findByEntityId(Long id) {
		return null;
	}

}
