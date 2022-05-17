package br.com.connemat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.AppBaseService;
import br.com.connemat.InstanceBaseService;
import br.com.connemat.InstanceDataSourceConfigBaseService;
import br.com.connemat.model.entity.App;
import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.InstanceDataSourceConfig;
import br.com.connemat.spring.data.repository.InstanceDataSourceConfigRepository;

@Service
@Validated
public class InstanceDataSourceConfigBaseServiceImpl 
extends ConnematBaseService<InstanceDataSourceConfig, Long, InstanceDataSourceConfigRepository> 
implements InstanceDataSourceConfigBaseService{

	@Autowired
	private InstanceBaseService instanceService;
	
	@Autowired
	private AppBaseService appService; 
	
	
	public InstanceDataSourceConfigBaseServiceImpl(@Autowired InstanceDataSourceConfigRepository rep) {
		super();
		this.repository=rep;
	}

	public void prepare(InstanceDataSourceConfig instanceDataSourceConfig) {
		Long instId = instanceDataSourceConfig.getInstance().getId();
		Instance instance = instanceService.findByEntityId(instId);
		instanceDataSourceConfig.setInstance(instance);
		App app = appService.findByEntityId(instanceDataSourceConfig.getApp().getId());
		instanceDataSourceConfig.setApp(app);
	}

	public void copyProperties(
			 InstanceDataSourceConfig instanceDataSourceConfig,
			InstanceDataSourceConfig ids) {
			BeanUtils.copyProperties(instanceDataSourceConfig, ids);
	}

	@Override
	@Transactional(transactionManager= "connemat-tm" )
	public List<InstanceDataSourceConfig> findByAppId(@Valid @NotNull Long id) {
		return repository.findByAppId(id);
	}

	@Override
	@Transactional(transactionManager= "connemat-tm" )
	public List<InstanceDataSourceConfig> findByInstanceId(@Valid @NotNull Long id) {
		return repository.findByInstanceId(id);
	}

}
