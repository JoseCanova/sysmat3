package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmValue;
import br.com.connemat.sysmat.model.entity.PdmValueAttribute;
import br.com.connemat.sysmat.repository.PdmValueAttributeRepository;
import br.com.connemat.sysmat.service.PdmValueAttributeBaseService;
import br.com.connemat.sysmat.service.PdmValueBaseService;

@Service 
@Validated
public class PdmValueAttributeServiceImpl 
extends BaseServiceImpl<PdmValueAttribute, Long, PdmValueAttributeRepository>
implements PdmValueAttributeBaseService {

	@Autowired 
	private PdmValueBaseService pdmValueService;
	
	public PdmValueAttributeServiceImpl(@Autowired PdmValueAttributeRepository repository) {
		super(repository);
	}

	@Override
	public void prepare(PdmValueAttribute s) {
		PdmValue pdm = pdmValueService.findByEntityId(s.getPdmValue().getId());
		s.setPdmValue(pdm);
	}
	
	public void copyProperties(
			PdmValueAttribute attribute,
			PdmValueAttribute att) {
			att.setKeyAttribute(attribute.getKeyAttribute());
			att.setValueAttribute(attribute.getValueAttribute());
			att.setPdmValue(attribute.getPdmValue());
	}


	@Validated
	@Transactional("tenant-tm")
	@Override
	public List<PdmValueAttribute> findByPdmValueId(@NotNull Long pdmValueId) {
		return repository.findByPdmValueId(pdmValueId);
	}

}
