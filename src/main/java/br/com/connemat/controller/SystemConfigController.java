package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.SystemConfigBaseService;
import br.com.connemat.model.entity.SystemConfig;

@RestController
@RequestMapping(path="/system_configs", 
produces=MediaType.APPLICATION_JSON_VALUE)
public class SystemConfigController 
extends EntityController<SystemConfig, Long, SystemConfigBaseService>{

	public SystemConfigController(@Autowired SystemConfigBaseService serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/system_configs/"+base.getId();
	}
	
}
