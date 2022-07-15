package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.CategoryAttribute;

@Validated
public interface CategoryAttributeBaseService 
extends CrudBaseService<CategoryAttribute,Long> {

	List<CategoryAttribute> findCategoryAttributeByCategoryId(@NotNull Long id);
	
	
}
