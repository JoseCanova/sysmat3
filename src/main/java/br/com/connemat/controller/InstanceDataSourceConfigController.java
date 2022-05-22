package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.InstanceDataSourceConfigBaseService;
import br.com.connemat.model.entity.InstanceDataSourceConfig;


@RestController
@RequestMapping(path="/instance-datasource-configs",
produces=MediaType.APPLICATION_JSON_VALUE)
@Profile(value="keycloak")
public class InstanceDataSourceConfigController extends
		EntityController<InstanceDataSourceConfig, Long, InstanceDataSourceConfigBaseService> {

	public InstanceDataSourceConfigController(@Autowired InstanceDataSourceConfigBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/instance-datasource-configs/"+base.getId();
	}
	
	@GetMapping(path="/app-id/{id}")
	public List<InstanceDataSourceConfig> findByAppId(@PathVariable(name="id",required=true) Long id) {
		return service.findByAppId(id);
	}

	@GetMapping(path="/instance-id/{id}")
	public List<InstanceDataSourceConfig> findByInstanceId(@PathVariable(name="id",required=true) Long id) {
		return service.findByInstanceId(id);
	}
	
}
