package br.com.connemat.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.SectorBaseService;
import br.com.connemat.model.entity.Sector;
import br.com.connemat.service.impl.ConnematBaseService;
import br.com.connemat.spring.data.repository.SectorRepository;

@Service
@Validated
public class SectorBaseServiceImpl 
extends ConnematBaseService<Sector , Long, SectorRepository> 
implements SectorBaseService {

	public SectorBaseServiceImpl(@Autowired SectorRepository repository) {
		super();
		this.repository = repository;
	}


	
}