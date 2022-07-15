package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.ReferenceType;
import br.com.connemat.sysmat.model.entity.ReferenceTypeDescription;
import br.com.connemat.sysmat.repository.ReferenceTypeDescriptionRepository;
import br.com.connemat.sysmat.service.ReferenceTypeBaseService;
import br.com.connemat.sysmat.service.ReferenceTypeDescriptionBaseService;

@Service
@Validated
@Qualifier(value="referenceTypeDescriptionBaseService")
@Primary
public class ReferenceTypeDescriptionServiceImpl 
extends BaseServiceImpl<ReferenceTypeDescription , Long , ReferenceTypeDescriptionRepository>
implements ReferenceTypeDescriptionBaseService{


	@Autowired
	private ReferenceTypeBaseService referenceTypeBaseService;
	
	public ReferenceTypeDescriptionServiceImpl(@Autowired ReferenceTypeDescriptionRepository repository) {
		super(repository);
	}

	@Override
	public void prepare(ReferenceTypeDescription s) {
		String refId = s.getReferenceType().getId();
		ReferenceType rt = referenceTypeBaseService.findByEntityId(refId);
		s.setReferenceType(rt);
	}

	public void copyProperties(
			ReferenceTypeDescription type,
			ReferenceTypeDescription rtd) {
			rtd.setLocale(type.getLocale());
			rtd.setDescription(type.getDescription());
			rtd.setReferenceType(type.getReferenceType());
	}

	@Override
	public List<ReferenceTypeDescription> findByReferenceTypeDescriptionsByReferenceTypeId(@Valid @NotEmpty String id) {
		return repository.findByReferenceTypeDescriptionsByReferenceTypeId(id);
	}

}
