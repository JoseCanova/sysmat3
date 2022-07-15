package br.com.connemat.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.AppBaseService;
import br.com.connemat.SystemConfigBaseService;
import br.com.connemat.model.entity.App;
import br.com.connemat.model.entity.SystemConfig;
import br.com.connemat.service.impl.ConnematBaseService;
import br.com.connemat.spring.data.repository.SystemConfigRepository;

@Validated
@Service
public class SystemConfigBaseServiceImpl 
extends ConnematBaseService<SystemConfig, Long, SystemConfigRepository>
implements SystemConfigBaseService {
	
	@Autowired
	private AppBaseService appService;
	
	public SystemConfigBaseServiceImpl(@Autowired SystemConfigRepository rep) {
		super();
		this.repository=rep;
	}

	@Override
	public void prepare(SystemConfig s) {
		String appId = s.getApp().getId();
		App app = appService.findByEntityId(appId);
		s.setApp(app);
	}
}
