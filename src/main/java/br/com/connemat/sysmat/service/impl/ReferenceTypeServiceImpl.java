package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.ReferenceType;
import br.com.connemat.sysmat.repository.ReferenceTypeRepository;
import br.com.connemat.sysmat.service.ReferenceTypeBaseService;

@Service
@Validated
public class ReferenceTypeServiceImpl 
extends BaseServiceImpl<ReferenceType , String , ReferenceTypeRepository> 
implements ReferenceTypeBaseService {

	public ReferenceTypeServiceImpl( @Autowired  ReferenceTypeRepository repository) {
		super(repository);
	}
	
}
