package br.com.connemat;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.connemat.model.entity.NcmTree;

public interface NcmTreeBaseService extends 
CrudBaseService<NcmTree,Long> {


	List<NcmTree> findNcmsByParentId(@Valid @NotNull Long parentId);
	
	Optional<NcmTree> findNcmTreeByCode(String code);
	
	
}
