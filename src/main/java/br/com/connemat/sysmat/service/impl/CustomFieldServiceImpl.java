package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.CustomField;
import br.com.connemat.sysmat.model.entity.CustomSection;
import br.com.connemat.sysmat.repository.CustomFieldRepository;
import br.com.connemat.sysmat.service.CustomFieldBaseService;
import br.com.connemat.sysmat.service.CustomSectionBaseService;

@Service
@Validated
public class CustomFieldServiceImpl 
extends BaseServiceImpl<CustomField, Long, CustomFieldRepository>
implements CustomFieldBaseService{

	//TODO: 
	@Autowired
	private CustomSectionBaseService customSectionService;
	
	public CustomFieldServiceImpl(@Autowired CustomFieldRepository repository) {
		super(repository);
	}

	@Override
	public void prepare(CustomField s) {
	}
	
	public void copyProperties(
			CustomField customField, CustomField cf) {
		BeanUtils.copyProperties(customField, cf);
	}

	@Transactional("tenant-tm")
	@Override
	public List<CustomField> findCustomFieldByCustomConfigValueId(@Valid @NotNull Long id) {
		return repository.findCustomFieldByCustomConfigValueId(id);
	}

}
