package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.AppBaseService;
import br.com.connemat.Base;
import br.com.connemat.model.entity.App;

@RestController
@RequestMapping(path="/apps",
produces=MediaType.APPLICATION_JSON_VALUE)
public class AppController extends EntityController<App,String , AppBaseService>{

	public AppController(@Autowired AppBaseService  serv) {
		super(serv);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/apps/"+base.getId();
	}
	
}
