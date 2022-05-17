package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmApprovedValue;
import br.com.connemat.sysmat.model.entity.PdmApprovedValueAttribute;
import br.com.connemat.sysmat.repository.PdmApprovedValueAttributeRepository;
import br.com.connemat.sysmat.service.PdmApprovedValueAttributeBaseService;
import br.com.connemat.sysmat.service.PdmApprovedValueBaseService;


@Service
@Validated
public class PdmApprovedValueAttributeServiceImpl 
extends BaseServiceImpl<PdmApprovedValueAttribute,Long,PdmApprovedValueAttributeRepository>
implements PdmApprovedValueAttributeBaseService{

	@Autowired
	private PdmApprovedValueBaseService pdmApprovedValueService;
	
	public PdmApprovedValueAttributeServiceImpl(@Autowired PdmApprovedValueAttributeRepository rep) {
		super(rep);
	}

	public void prepare(PdmApprovedValueAttribute pdmApprovedValueAttribute) {
		Long pdmApprovedValueId = pdmApprovedValueAttribute.getPdmApprovedValue().getId();
		PdmApprovedValue theVaue = pdmApprovedValueService.findByEntityId(pdmApprovedValueId);
		pdmApprovedValueAttribute.setPdmApprovedValue(theVaue);
	}

	public void copyProperties(PdmApprovedValueAttribute pdmApprovedValueAttribute,
			PdmApprovedValueAttribute v) {
			v.setKeyAttribute(pdmApprovedValueAttribute.getKeyAttribute());
			v.setValueAttrbute(pdmApprovedValueAttribute.getValueAttrbute());
			v.setPdmApprovedValue(pdmApprovedValueAttribute.getPdmApprovedValue());
	}

	@Override
	public List<PdmApprovedValueAttribute> findByPdmApprovedValueId(@Valid @NotNull Long id) {
		return repository.findByPdmApprovedValueId(id);
	}

}
