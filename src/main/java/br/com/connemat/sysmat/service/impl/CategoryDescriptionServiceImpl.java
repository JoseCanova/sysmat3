package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Category;
import br.com.connemat.sysmat.model.entity.CategoryDescription;
import br.com.connemat.sysmat.repository.CategoryDescriptionRepository;
import br.com.connemat.sysmat.service.CategoryBaseService;
import br.com.connemat.sysmat.service.CategoryDescriptionBaseService;

@Service
@Primary
@Validated
public class CategoryDescriptionServiceImpl
extends BaseServiceImpl<CategoryDescription, Long, CategoryDescriptionRepository>
implements CategoryDescriptionBaseService {

	@Autowired
	private CategoryBaseService categoryService;

	public CategoryDescriptionServiceImpl(@Autowired CategoryDescriptionRepository reposotory)
	{
		super(reposotory);
	}


	@Override
	public void prepare(CategoryDescription s) {
		Long categoryId = s.getCategory().getId();
		Category cat = categoryService.findByEntityId(categoryId);
		s.setCategory(cat);
	}


	@Override
	@Transactional("tenant-tm")
	public List<CategoryDescription> findCategoryDescriptionByCategoryId(@NotNull Long id) {
		return repository.findCategoryDescriptionByCategoryId(id);
	}

}
