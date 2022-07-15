package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.FieldType;
import br.com.connemat.sysmat.model.entity.util.FieldTypeEnum;
import br.com.connemat.sysmat.repository.FieldTypeRepository;
import br.com.connemat.sysmat.service.FieldTypeBaseService;

@Service
@Validated
public class FieldTypeServiceImpl 
extends BaseServiceImpl<FieldType, FieldTypeEnum, FieldTypeRepository>
implements FieldTypeBaseService {


	public FieldTypeServiceImpl(@Autowired FieldTypeRepository repository) {
		super(repository);
	}

}
