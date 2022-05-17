package br.com.connemat.rest.client.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.InstanceDataSourceConfig;

@Valid
public class InstanceDataSourceRepresentation {

	@NotNull
	private Instance instance; 
	
	
	@NotNull
	private InstanceDataSourceConfig instanceDataSourceConfig;

	
	

	public InstanceDataSourceRepresentation() {
		super();
	}

	
	
	public InstanceDataSourceRepresentation(Instance instance,
			InstanceDataSourceConfig instanceDataSourceConfig) {
		super();
		this.instance = instance;
		this.instanceDataSourceConfig = instanceDataSourceConfig;
	}

	public Instance getInstance() {
		return instance;
	}


	public void setInstance(Instance instance) {
		this.instance = instance;
	}


	public InstanceDataSourceConfig getInstanceDataSourceConfig() {
		return instanceDataSourceConfig;
	}


	public void setInstanceDataSourceConfig(InstanceDataSourceConfig instanceDataSourceConfig) {
		this.instanceDataSourceConfig = instanceDataSourceConfig;
	}
	
	
	
}
