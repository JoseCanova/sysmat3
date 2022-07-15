package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.SubCategory;
import br.com.connemat.sysmat.model.entity.SubCategoryAttribute;
import br.com.connemat.sysmat.repository.SubCategoryAttributeRepository;
import br.com.connemat.sysmat.service.SubCategoryAttributeBaseService;
import br.com.connemat.sysmat.service.SubCategoryBaseService;

@Service
@Validated
public class SubCategoryAttributeServiceImpl 
extends BaseServiceImpl<SubCategoryAttribute, Long, SubCategoryAttributeRepository>
implements SubCategoryAttributeBaseService {

	@Autowired
	private SubCategoryBaseService categoryService;
	
	public SubCategoryAttributeServiceImpl(SubCategoryAttributeRepository repository) {
		super(repository);
	}
	
	@Override
	public void prepare(SubCategoryAttribute s) {
		SubCategory theCat = categoryService.findByEntityId(s.getSubCategory().getId());
		s.setSubCategory(theCat);
	}
	
	public void copyProperties(
			SubCategoryAttribute categoryAttribute,
			SubCategoryAttribute ca) {
		ca.setValueAttribute(categoryAttribute.getValueAttribute());
		ca.setKeyAttribute(categoryAttribute.getKeyAttribute());
		ca.setSubCategory(categoryAttribute.getSubCategory());
	}

	@Transactional("tenant-tm")
	@Override
	public  List<SubCategoryAttribute> findSubCategoryAttributeBySubCategoryId(@Valid @NotNull Long id) {
		return repository.findSubCategoryAttributeBySubCategoryId(id);
	}

}
