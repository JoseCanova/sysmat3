package br.com.connemat.sysmat.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.CrudBaseService;
import br.com.connemat.sysmat.model.entity.CategoryDescription;

@Validated
public interface CategoryDescriptionBaseService extends CrudBaseService<CategoryDescription,Long> {
	
	List<CategoryDescription> findCategoryDescriptionByCategoryId(@NotNull Long id);
}
