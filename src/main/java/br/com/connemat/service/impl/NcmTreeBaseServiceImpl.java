package br.com.connemat.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.NcmTree;
import br.com.connemat.spring.data.repository.NcmTreeRepository;

@Service
@Validated
public class NcmTreeBaseServiceImpl
extends ConnematBaseService<NcmTree, Long, NcmTreeRepository>
implements NcmTreeBaseService {

	public NcmTreeBaseServiceImpl(@Autowired NcmTreeRepository repository) {
		this.repository = repository;
	}
	
	public void copyProperties(NcmTree tree, NcmTree t) {
		t.setCode(tree.getCode());
		t.setDescription(tree.getDescription());
		t.setParent(tree.getParent());
	}


	@Override
	public List<NcmTree> findNcmsByParentId(@Valid @NotNull Long parentId) {
		return repository.findNcmsByParentId(parentId);
	}

	@Override
	public Optional<NcmTree> findNcmTreeByCode(String code) {
		return repository.findNcmTreeByCode(code);
	}

}
