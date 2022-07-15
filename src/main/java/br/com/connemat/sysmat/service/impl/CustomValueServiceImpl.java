package br.com.connemat.sysmat.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.CustomField;
import br.com.connemat.sysmat.model.entity.CustomValue;
import br.com.connemat.sysmat.repository.CustomValueRepository;
import br.com.connemat.sysmat.service.CustomFieldBaseService;
import br.com.connemat.sysmat.service.CustomValueBaseService;

@Service 
@Validated
public class CustomValueServiceImpl 
extends BaseServiceImpl<CustomValue,Long,CustomValueRepository>
implements CustomValueBaseService {


	@Autowired
	private CustomFieldBaseService customFieldService;
	
	public CustomValueServiceImpl(@Autowired CustomValueRepository repository) {
		super(repository);
	}

	@Override
	public void prepare(CustomValue s) {
		CustomField cf = customFieldService.findByEntityId(s.getField().getId());
		s.setField(cf);
	}
	
	public void copyProperties(
			CustomValue customValue, CustomValue cv) {
		BeanUtils.copyProperties(customValue, cv);
	}

	@Transactional("tenant-tm")
	@Override
	public CustomValue addParentCustomValue(
			@Valid @NotNull(groups = UpdateValidationGroup.class) Long childId,
			@Valid @NotNull(groups = UpdateValidationGroup.class) CustomValue theParentCustomValue) {
		return findById(childId)
				.filter(ccv -> !ccv.getId().equals(theParentCustomValue.getId()))
				.map(ccv -> {
					CustomValue cvp = findByEntityId(theParentCustomValue.getId());
					verifyNotParentOf(ccv.getParentCustomValues(),cvp);
					verifyNotParentOf(cvp.getParentCustomValues(),ccv);
					ccv.getParentCustomValues().add(cvp);
					return save(ccv);
				}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

	private CustomValue verifyNotParentOf(Set<CustomValue> parentCustomValues, CustomValue ccv) {
		Optional
		.ofNullable(parentCustomValues.contains(ccv))
		.filter(contains -> contains != true)
		.orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
		return ccv;
	}

	@Transactional("tenant-tm")
	@Override
	public CustomValue deleteParentCustomValue(
			@Valid @NotNull(groups=UpdateValidationGroup.class) Long childId, 
			@Valid @NotNull(groups = UpdateValidationGroup.class) CustomValue parentCustomValue) {
		return findById(childId)
				.filter(ccv -> !ccv.getId().equals(parentCustomValue.getId()))
				.map(ccv -> {
					CustomValue ccp = findByEntityId(parentCustomValue.getId());
					verifyParentOf(ccv.getParentCustomValues() , ccp);
					ccv.getParentCustomValues().remove(ccp);
					return save(ccv);
		}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

	private CustomValue verifyParentOf(Set<CustomValue> parentCustomValues, CustomValue ccp) {
		Optional
		.ofNullable(parentCustomValues.contains(ccp))
		.filter(contains -> contains == true)
		.orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
		return ccp;
	}

	@Transactional("tenant-tm")
	@Override
	public List<CustomValue> findCustomValuesByParentCustomValueId(Long id) {
		return repository.findCustomValuesByParentCustomValueId(id);
	}

}
