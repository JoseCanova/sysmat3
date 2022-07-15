package org.keycloak.models.controller.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.repository.GroupEntityRepository;
import org.keycloak.models.utils.GroupEntityGroupConverter;
import org.keycloak.models.utils.GroupEntityRepresentationConverter;
import org.keycloak.models.utils.GroupRepresentationGroupConverter;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.connemat.GroupBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.rest.client.AdminRestClient;

@Service
@Primary
@Profile(value = "keycloak")
public class GroupEntityService
implements GroupBaseService{

	@Autowired
	private GroupEntityRepository repository;
	
	@Autowired
	private GroupRepresentationGroupConverter converter;
	
	@Autowired
	private GroupEntityGroupConverter groupEntityGroupConverter;
	
	@Autowired
	private AdminRestClient adminRestClient;
	
	public GroupEntityService() {
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findByAttributesName( String attributeName) {
		return repository.findByAttributesName(attributeName);
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findByAttributesNameAndRealm( String attributeName, String realm) {
		return repository.findByAttributesNameAndRealm(attributeName, realm);
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findByIdIn(  List<String> ids) {
		return repository.findByIdIn(ids);
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findAllById( Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Transactional("keycloak-tm")
	public Optional<GroupEntity> findById( String id) {
		return repository.findById(id);
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findByRealm( String realm) {
		return repository.findByRealm(realm);
	}

	@Transactional("keycloak-tm")
	public List<GroupEntity> findByIdInAndAttributesName(List<String> gIds, String string) {
		return repository.findByIdInAndAttributesName(gIds,string);
	}
	
	@Transactional("keycloak-tm")
	public GroupEntity addGroup( GroupEntity groupEntity) {
		return repository.save(groupEntity);
	}
	
	@Transactional("keycloak-tm")
	public void deleteGroup( GroupEntity groupEntity) {
		GroupEntity theGroup = new GroupEntity();
		theGroup.setId(groupEntity.getId());
		Example<GroupEntity> ex = Example.of(theGroup);
		Optional<GroupEntity> result = repository.findOne(ex);
		result.ifPresent(g ->{
			repository.delete(g);
		});
	}

	@Transactional("keycloak-tm")
	public Optional<GroupEntity> findOne(Example<GroupEntity> exGe) {
		return repository.findOne(exGe);
	}

	/**
	 * 
	 * @param groupEntity
	 * @return ResponseEntity<?> - 201 code sucess.
	 */
	public ResponseEntity<?> addGroupEntity( GroupEntity groupEntity){
		GroupEntityRepresentationConverter grec = new GroupEntityRepresentationConverter();
		GroupRepresentation gr = grec.convert(groupEntity);
		return adminRestClient.addGroup(gr);
	}

	public void deleteGroupEntity(GroupEntity g) {
		adminRestClient.deleteGroupEntity(g);
	}
	
	public List<Group> getAllGroups(){
		GroupRepresentation[] representations = adminRestClient.getGroups(0, 1000);
		return Arrays
			.asList(representations)
			.stream()
			.map(gr -> {return converter.convert(gr);})
			.collect(Collectors.toList());
	}

	@Override
	public List<Group> getGroups(String searchString) {
		GroupRepresentation[] representations =  adminRestClient.getGroups(0, 1000,searchString);
		return Arrays
				.asList(representations)
				.stream()
				.map(gr -> {return converter.convert(gr);})
				.collect(Collectors.toList());
	}

	@Override
	public Group getGroup(String id) {
		GroupRepresentation representation =  adminRestClient.getGroup(id);
		return converter.convert(representation);
	}

	@Override
	public void deleteGroup( String id) {
		adminRestClient.deleteGroup(id);
	}
	
	@Override
	public @Nullable Group updateGroup( String id,  Group group) {
		GroupRepresentation gr = converter.doBackward(group);
		ResponseEntity<?> response = adminRestClient.updateGroup(id , gr);
		return group;
	}
	
	public @Nullable Group addSubGroup( String id,  Group group) {
		GroupRepresentation gr = converter.doBackward(group);
		adminRestClient.createUpdateSubGroup(id , gr);
		GroupEntity ge = new GroupEntity();
		ge.setName(group.getName());
		ge.setRealm("connemat");
		ge.setParentId(id);
		Example<GroupEntity> example = Example.of(ge);
		Optional<GroupEntity>optGroup = findOne(example);
		GroupRepresentation grr = optGroup
		.map(g -> {
			 return adminRestClient.getGroup(g.getId());
		}).orElseThrow(RuntimeException::new);
		return converter.convert(grr);
	}

	@Override
	public Group addGroup( Group group) {
		GroupRepresentation gr = converter.doBackward(group);
		adminRestClient.createGroup(gr);
		GroupEntity ge = new GroupEntity();
		ge.setName(group.getName());
		ge.setRealm("connemat");
		Example<GroupEntity> example = Example.of(ge);
		Optional<GroupEntity>optGroup = findOne(example);
		GroupRepresentation grr = optGroup
		.map(g -> {
			 return adminRestClient.getGroup(g.getId());
		}).orElseThrow(RuntimeException::new);
		return converter.convert(grr);
	}

	@Override
	public List<Group> getGroups( String searchString,  String attributeName) {
		return null;
	}

	@Override
	@Transactional("keycloak-tm")
	public List<Group> getGroupsBytAttributeName( String realmId,  String attributeName) {
		List<GroupEntity> groupEntities = findByAttributesNameAndRealm(attributeName, realmId);
		return groupEntities.stream().map(e ->{
			return toGroup(e);
		}).collect(Collectors.toList());
	}

	private Group toGroup(GroupEntity e) {
		return groupEntityGroupConverter.convert(e);
	}

	@Override
	public List<Group> getUserGroupsBytAttributeName( String attributeName, Authentication authentication) {
		return null;
	}

}
