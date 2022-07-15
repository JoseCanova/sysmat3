package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.Category;
import br.com.connemat.sysmat.model.entity.CategoryAttribute;
import br.com.connemat.sysmat.repository.CategoryAttributeRepository;
import br.com.connemat.sysmat.service.CategoryAttributeBaseService;
import br.com.connemat.sysmat.service.CategoryBaseService;

@Service
@Validated
public class CategoryAttributeServiceImpl 
extends BaseServiceImpl<CategoryAttribute, Long, CategoryAttributeRepository>
implements CategoryAttributeBaseService {

	@Autowired
	private CategoryBaseService categoryService;

	public CategoryAttributeServiceImpl(CategoryAttributeRepository repository) {
		super(repository);
	}

	@Override
	@Transactional("tenant-tm")
	public CategoryAttribute updateEntity(@Valid @NotNull(groups = UpdateValidationGroup.class) Long id,
			@Valid @NotNull(groups = UpdateValidationGroup.class) CategoryAttribute entity) {
		return 	findById(id)
				.filter(ca -> ca.getId().equals(entity.getId()))
				.map(ca ->{
					copyProperties(entity, ca);
					prepare(ca);
					return save(ca);
				}).orElseThrow();
	}

	@Override
	public void prepare(CategoryAttribute s) {
		Long catId = s.getCategory().getId();
		Category cat = categoryService.findByEntityId(catId);
		s.setCategory(cat);
	}	
	
	@Override
	@Transactional("tenant-tm")
	public List<CategoryAttribute> findCategoryAttributeByCategoryId(@NotNull Long id) {
		return repository.findCategoryAttributeByCategoryId(id);
	}

}
