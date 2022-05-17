package br.com.connemat.sysmat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.connemat.sysmat.model.entity.Category;
import br.com.connemat.sysmat.repository.CategoryRepository;
import br.com.connemat.sysmat.service.CategoryBaseService;

@Service
public class CategoryServiceImpl 
extends BaseServiceImpl<Category , Long, CategoryRepository> 
implements CategoryBaseService{

	public CategoryServiceImpl(@Autowired CategoryRepository repository) {
		super(repository);
	}
}