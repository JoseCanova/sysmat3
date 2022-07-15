package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.PdmValue;
import br.com.connemat.sysmat.model.entity.PdmValueDescription;
import br.com.connemat.sysmat.repository.PdmValueDescriptionRepository;
import br.com.connemat.sysmat.service.PdmValueBaseService;
import br.com.connemat.sysmat.service.PdmValueDescriptionBaseService;

@Service
@Validated
public class PdmValueDescriptionServiceImpl
		extends BaseServiceImpl<PdmValueDescription, Long, PdmValueDescriptionRepository>
		implements PdmValueDescriptionBaseService {

	@Autowired
	private PdmValueBaseService pdmService;

	public PdmValueDescriptionServiceImpl(@Autowired PdmValueDescriptionRepository repository) {
		super(repository);
	}


	@Override
	public void prepare(PdmValueDescription s) {
		PdmValue pdm = pdmService.findByEntityId(s.getPdmValue().getId());
		s.setPdmValue(pdm);
	}
	
	public void copyProperties(
			PdmValueDescription description,
			PdmValueDescription vd) {
		vd.setLocale(description.getLocale());
		vd.setDescription(description.getDescription());
		vd.setPdmValue(description.getPdmValue());
	}


	@Transactional("tenant-tm")
	@Override
	public @NotEmpty List<PdmValueDescription> findByPdmValueId(@NotNull Long pdmValueId) {
		return repository.findByPdmValueId(pdmValueId);
	}

}
