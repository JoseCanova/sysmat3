package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.SectorBaseService;
import br.com.connemat.model.entity.Sector;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path="/sectors" , 
produces=MediaType.APPLICATION_JSON_VALUE)
public class SectorController 
extends EntityController<Sector, Long, SectorBaseService>{

	public SectorController(@Autowired SectorBaseService service) {
		super(service);
	}

	
}
