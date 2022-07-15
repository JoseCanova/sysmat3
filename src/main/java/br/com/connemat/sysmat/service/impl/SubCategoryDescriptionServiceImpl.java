package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.SubCategory;
import br.com.connemat.sysmat.model.entity.SubCategoryDescription;
import br.com.connemat.sysmat.repository.SubCategoryDescriptionRepository;
import br.com.connemat.sysmat.service.SubCategoryBaseService;
import br.com.connemat.sysmat.service.SubCategoryDescriptionBaseService;

@Service
@Validated
public class SubCategoryDescriptionServiceImpl
		extends BaseServiceImpl<SubCategoryDescription, Long, SubCategoryDescriptionRepository>
		implements SubCategoryDescriptionBaseService {

	@Autowired
	private SubCategoryBaseService categoryService;
	
	public SubCategoryDescriptionServiceImpl(@Autowired SubCategoryDescriptionRepository reposotory)
	{
		super(reposotory);
	}

	@Override
	public void prepare(SubCategoryDescription s) {
		Long catId = s.getSubCategory().getId();
		SubCategory sub = categoryService.findByEntityId(catId);
		s.setSubCategory(sub);
	}
	
	@Override
	public void copyProperties(SubCategoryDescription entity, SubCategoryDescription s) {
		s.setLocale(entity.getLocale());
		s.setDescription(entity.getDescription());
		s.setSubCategory(entity.getSubCategory());
	}
	
	@Transactional("tenant-tm")
	@Override
	public List<SubCategoryDescription> findSubCategoryByCategoryId(@Valid @NotNull Long id) {
		return repository.findSubCategoryByCategoryId(id);
	}

}
