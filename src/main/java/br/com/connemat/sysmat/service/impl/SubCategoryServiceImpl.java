package br.com.connemat.sysmat.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.sysmat.model.entity.Category;
import br.com.connemat.sysmat.model.entity.SubCategory;
import br.com.connemat.sysmat.repository.SubCategoryRepository;
import br.com.connemat.sysmat.service.CategoryBaseService;
import br.com.connemat.sysmat.service.SubCategoryBaseService;

@Service
@Primary
@Validated
public class SubCategoryServiceImpl 
extends BaseServiceImpl<SubCategory , Long, SubCategoryRepository> 
implements SubCategoryBaseService{

	@Autowired
	private CategoryBaseService categoryService;
	
	public SubCategoryServiceImpl(@Autowired SubCategoryRepository repository) {
		super(repository);
	}

	@Override
	public void prepare(SubCategory s) {
		Category cat = categoryService.findByEntityId(s.getCategory().getId());
		s.setCategory(cat);
	}
	
	public void copyProperties( SubCategory category,
			SubCategory cat) {
		cat.setDescription(category.getDescription());
		cat.setCategory(category.getCategory());
	}

	public 	List<SubCategory> findSubCategoryByCatagoryId(@Valid @NotNull Long id){
		return repository.findSubCategoryByCatagoryId(id);
	}

}
