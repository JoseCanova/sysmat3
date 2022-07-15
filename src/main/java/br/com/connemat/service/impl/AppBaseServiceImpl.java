package br.com.connemat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.AppBaseService;
import br.com.connemat.model.entity.App;
import br.com.connemat.spring.data.repository.AppRepository;

@Service
@Validated
public class AppBaseServiceImpl 
extends ConnematBaseService<App, String, AppRepository> 
implements AppBaseService{


	public AppBaseServiceImpl(@Autowired AppRepository rep) {
		super();
		this.repository=rep;
	}
}
