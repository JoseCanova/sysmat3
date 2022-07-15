package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.connemat.sysmat.model.entity.CustomSection;
import br.com.connemat.sysmat.repository.CustomSectionRepository;
import br.com.connemat.sysmat.service.CustomSectionBaseService;

@Service
public class CustomSectionServiceImpl 
extends BaseServiceImpl<CustomSection , Long , CustomSectionRepository>
implements CustomSectionBaseService{

	public CustomSectionServiceImpl(@Autowired CustomSectionRepository repository) {
		super(repository);
	}

	public void copyProperties(CustomSection section, CustomSection cs) {
		cs.setCode(section.getCode());
		cs.setOrderPosition(section.getOrderPosition());
		cs.setDescription(section.getDescription());
	}

}
