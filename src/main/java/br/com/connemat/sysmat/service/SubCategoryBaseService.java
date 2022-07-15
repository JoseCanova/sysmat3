package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.SubCategory;

public interface SubCategoryBaseService 
extends CrudBaseService<SubCategory,Long> {

	List<SubCategory> findSubCategoryByCatagoryId(@Valid @NotNull Long id);
	
}
