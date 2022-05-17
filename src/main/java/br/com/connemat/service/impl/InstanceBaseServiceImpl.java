package br.com.connemat.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.keycloak.models.jpa.entities.GroupAttributeEntity;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.GroupBaseService;
import br.com.connemat.InstanceBaseService;
import br.com.connemat.SectorBaseService;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.api.AttributeValue;
import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.InstanceDataSourceConfig;
import br.com.connemat.model.entity.Sector;
import br.com.connemat.spring.data.repository.InstanceRepository;

@Validated
@Service
public class InstanceBaseServiceImpl 
extends ConnematBaseService<Instance,Long,InstanceRepository> 
implements InstanceBaseService {

	public static final String INSTANCE_ATTRIBUTE = "instance";
	
	@Autowired
	private GroupBaseService groupService;
	
	@Autowired
	private SectorBaseService sectorBaseService;

	public InstanceBaseServiceImpl(	@Autowired InstanceRepository instanceRepository) {
		this.repository=instanceRepository;
	}
	

	@Override
	@Validated(value =  {UpdateValidationGroup.class })
	public Instance updateInstance( Long id , Instance instance) {
		return findById(instance.getId()).map(i -> {
			copyProperties(instance , i);
			Optional
				.ofNullable(instance.getSector())
				.map(s -> {
					Sector sectorOpt = sectorBaseService.findByEntityId(s.getId());
					i.setSector(sectorOpt);
					return true;
				}).orElseThrow(RuntimeException::new);
			return save(i);
		}).orElseThrow(RuntimeException::new);
	}

	
	public void prepare(Instance instance) {
		Sector sectorOpt = sectorBaseService.findByEntityId(instance.getSector().getId());
		instance.setSector(sectorOpt);
	}
	
	public void copyProperties(Instance instance,Instance i) {
		i.setDescription(instance.getDescription());
		i.setLogo(Optional.ofNullable(instance.getLogo()).orElse(i.getLogo()));
		i.setLogoSmall(Optional.ofNullable(instance.getLogoSmall()).orElse(i.getLogoSmall()));
		i.setManual(Optional.ofNullable(instance.getManual()).orElse(i.getManual()));
		i.setActive(instance.getActive());
		i.setCode(instance.getCode());
		i.setSector(instance.getSector());
	}

	public Object deleteInstance(Long id) {
		return findById(id)
		.map(instance ->{
			deleteOnTransaction(id);
			deleteInstanceGroup(instance);
			return true;
		}).orElseThrow();
	}
	
	@Transactional(transactionManager= "connemat-tm"  , propagation=Propagation.REQUIRES_NEW , isolation = Isolation.READ_COMMITTED)
	private void deleteOnTransaction(Long  id) {
		findById(id)
		.map(instance ->{
			delete(instance);
			return true;
		}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}


	private void deleteInstanceGroup(Instance instance) {
	 GroupEntity ge = new GroupEntity();
		ge.setName(instance.getCode());
		ge.setParentId(GroupEntity.TOP_PARENT_ID);
		Optional<GroupEntity> geOptional = groupService.findOne(Example.of(ge));
		if(geOptional.isPresent())
			groupService.deleteGroup(geOptional.get().getId());
	}
	
	@Transactional
	public Instance saveInstanceDataSourceConfig(Instance instance, InstanceDataSourceConfig config) {
		Instance instanceEx = new Instance(); 
		instanceEx.setCode(instanceEx.getCode());
		Example<Instance> exp = Example.of(instanceEx);
		return findOne(exp)
				.map(i ->{
						i.setInstanceConfigDataSource(config);
						return save(i);
					}).orElseThrow(RuntimeException::new);
	}

	public Instance addInstance(Instance instance) {
		return Optional
				.ofNullable(instance)
				.map(i ->{
					Sector sector = instance.getSector();
					Sector sectorOpt = sectorBaseService.findByEntityId(sector.getId());
					i.setSector(sectorOpt);
					Instance theInstance = save(i);
					createGroupInstance(theInstance);
					return theInstance;
				}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

	@Validated
	public Instance saveInstanceGroup(@Valid Instance instance){
		ResponseEntity<?> response = createGroupInstance(instance);
		if (response.getStatusCodeValue() != 201)
			throw new RuntimeException();
		return save(instance);
	}
	
	@Transactional("connemat-tm")
	@Validated(value =  {UpdateValidationGroup.class ,  Default.class})
	public Instance activateInstance(@Valid @NotNull Instance instance) {
		return findById(instance.getId())
		.map(i ->{
			i.setActive(instance.getActive());
			return save(i);
		}).orElseThrow(exceptionSupplierFactory.applyMessage("data.integrity"));
	}

	private ResponseEntity<?> createGroupInstance(Instance instance) {
		GroupEntity ge = new GroupEntity();
		GroupAttributeEntity gar = new GroupAttributeEntity();
		gar.setName(INSTANCE_ATTRIBUTE);
		gar.setValue("1");
		ge.getAttributes().add(gar);
		ge.setName(instance.getCode());
		ge.setParentId(GroupEntity.TOP_PARENT_ID);
		ge.setRealm("connemat");
		return groupService.addGroupEntity(ge);
	}

	@Override
	public List<Instance> findIntanceBySectorId(@Valid @NotNull Long sectorId) {
		return repository.findIntanceBySectorId(sectorId);
	}

	@Override
	public AttributeValue<?> getLobAttribute(@Valid @NotNull Long id, String attributeName) {
		return getLazyAttribute(id, attributeName);
	}


}
