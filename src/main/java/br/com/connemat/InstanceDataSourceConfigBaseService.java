package br.com.connemat;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.InstanceDataSourceConfig;

@Validated
public interface InstanceDataSourceConfigBaseService 
extends CrudBaseService<InstanceDataSourceConfig, Long> {

	List<InstanceDataSourceConfig> findByAppId(@Valid @NotNull Long id);
	
	List<InstanceDataSourceConfig> findByInstanceId(@Valid @NotNull Long id);
	
}
