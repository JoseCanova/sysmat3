package br.com.connemat.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.NcmBaseService;
import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.Ncm;
import br.com.connemat.model.entity.NcmTree;
import br.com.connemat.spring.data.repository.NcmRepository;

@Service
@Validated
public class NcmBaseServiceImpl 
extends ConnematBaseService<Ncm, String, NcmRepository>
implements NcmBaseService{

	@Autowired
	private NcmTreeBaseService treeService;
	
	public NcmBaseServiceImpl(@Autowired NcmRepository theRepository) {
		this.repository=theRepository;
	}

	@Override
	public Ncm addNcm(Ncm ncm) {
		return save(ncm);
	}

	@Override
	public Ncm updateNcm(String code , Ncm ncm) {
		return findById(code)
				.filter(n -> n.getNcmCode().equals(code))
				.map(n -> {
					copyProperties (ncm  , n);
					return save (n);
				}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

	@Override
	public void prepare(Ncm s) {
		NcmTree nt = treeService.findByEntityId(s.getNcmTree().getId());
		s.setNcmTree(nt);
	}
	
	public void copyProperties(Ncm ncm, Ncm n) {
		n.setDescription(ncm.getDescription());
		n.setStartDate(n.getStartDate());
		n.setEndDate(n.getEndDate());
		n.setNcmCode(ncm.getNcmCode());
		n.setNcmTree(ncm.getNcmTree());
	}

	@Override
	public Object deleteNcm(String code) {
		return findById(code)
				.map(n -> {
					delete(n);
					return true;
				}).orElseThrow();
	}

	@Override
	public Ncm findByNcmId(String code) {
		return findById(code).orElseThrow();
	}

	@Override
	public Optional<Ncm> findNcmByNcmCode(String code) {
		return repository
				.findNcmByNcmCode(code);
	}

}