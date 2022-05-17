package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Pdm;
import br.com.connemat.sysmat.model.entity.SubCategory;
import br.com.connemat.sysmat.repository.PdmRepository;
import br.com.connemat.sysmat.service.PdmBaseService;
import br.com.connemat.sysmat.service.SubCategoryBaseService;

@Service
@Validated
public class PdmServiceImpl 
extends BaseServiceImpl<Pdm, Long, PdmRepository> 
implements PdmBaseService {

	@Autowired 
	private SubCategoryBaseService subCategoryBaseService;
	
	public PdmServiceImpl(@Autowired PdmRepository rep) {
		super(rep);
	}

	@Override
	public void prepare(Pdm s) {
		SubCategory cat = s.getSubCategory();
		SubCategory theCat = subCategoryBaseService.findByEntityId(cat.getId());
		s.setSubCategory(theCat);
	}

	public void copyProperties( Pdm pdm, Pdm p) {
		p.setDisabled(pdm.getDisabled());
		p.setPdmName(pdm.getPdmName());
		p.setShortAbbreviation(pdm.getShortAbbreviation());
		p.setLongAbbreviation(pdm.getLongAbbreviation());
		p.setSubCategory(pdm.getSubCategory());
	}
	

}
