package br.com.connemat.sysmat.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.exception.SysmatEntityException;
import br.com.connemat.sysmat.model.entity.Center;
import br.com.connemat.sysmat.model.entity.Company;
import br.com.connemat.sysmat.repository.CenterRepository;
import br.com.connemat.sysmat.service.CenterBaseService;
import br.com.connemat.sysmat.service.CompanyBaseService;

@Service
@Validated
public class CenterServiceImpl extends BaseServiceImpl<Center , Long , CenterRepository> 
implements CenterBaseService{

	
	@Autowired
	private CompanyBaseService companyService;
	
	public CenterServiceImpl(@Autowired CenterRepository repository) {
		super(repository);
	}
	

	@Override
	public void prepare(Center s) {
			Company theCompany  = companyService.findByEntityId(s.getCompany().getId());
			s.setCompany(theCompany);
	}
	
	public void copyProperties(Center center, Center c) {
		c.setCode(center.getCode());
		c.setDescription(center.getDescription());
		c.setComments(center.getComments());
		c.setDisabled(center.getDisabled());
		c.setLastUpdatedDate(LocalDateTime.now());
		c.setCompany(center.getCompany());
	}


	@Validated(value= {UpdateValidationGroup.class})
	@Override
	public Object deactivateCenter(@Valid @NotNull Long id) {
		return findById(id)
		.map(c -> {
				LocalDateTime now = LocalDateTime.now();
				c.setDisabled(true);
				c.setLastUpdatedDate(now);
				c.setInactivationDate(now);
				validateDeactivation(c);
				save(c);
				return true;
		})
		.orElseThrow(SysmatEntityException::new);
	}

	@Transactional("tenant-tm")
	@Override
	public List<Center> findCenterByCompanyId(@Valid @NotNull Long id) {
		return repository.findCenterByCompanyId(id);
	}
	
}
