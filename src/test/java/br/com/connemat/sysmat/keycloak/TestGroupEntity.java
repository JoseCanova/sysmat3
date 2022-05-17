package br.com.connemat.sysmat.keycloak;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.keycloak.models.controller.services.GroupEntityService;
import org.keycloak.models.controller.services.RealmEntityService;
import org.keycloak.models.jpa.entities.GroupAttributeEntity;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.jpa.entities.RealmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TestGroupEntity {

	@Autowired private GroupEntityService groupEntityService;
	
	@Autowired private RealmEntityService realmEntityService;
	
	public static final String DEFAULT_GROUP_NAME =  "GroupNameTherapy111A";

	@Test
	void testResourceCreation() {
		assertNotNull(groupEntityService);
	}
	
	@Test
	void testAddGroupEntity() {
		Optional<RealmEntity> re = realmEntityService.findById("connemat");
		GroupEntity ge = new GroupEntity();
		ge.setName(DEFAULT_GROUP_NAME);
		ge.setParentId(GroupEntity.TOP_PARENT_ID);
		ge.setRealm(re.get().getName());
		GroupEntity theGroup = groupEntityService.addGroup(ge);
		assertNotNull(theGroup);
	}
	
	@Test
	void deleteDefaultGroup() {
		GroupEntity ge = new GroupEntity();
		ge.setName(DEFAULT_GROUP_NAME);
		Example<GroupEntity> exGe = Example.of(ge);
		Optional<GroupEntity> theGroupOpt = groupEntityService.findOne(exGe);
		theGroupOpt.ifPresent(g ->{
			groupEntityService.deleteGroup(g);
		});
	}
	
	@Test
	void testAddGroupEntityByApi() {
		GroupEntity ge = new GroupEntity();
		ge.setName(DEFAULT_GROUP_NAME);
		ge.setParentId(GroupEntity.TOP_PARENT_ID);
		ge.setRealm("connemat");
		ResponseEntity<?> response = groupEntityService.addGroupEntity(ge);
		System.err.println(response.getStatusCodeValue());
		assertTrue(response.getStatusCodeValue() == 201); //Response Empty
	}
	
	@Test
	void testDeleteGroupEntityByApi() {
		GroupEntity ge = new GroupEntity();
		ge.setName(DEFAULT_GROUP_NAME);
		Example<GroupEntity> example = Example.of(ge);
		Optional<GroupEntity> geOpt = groupEntityService.findOne(example);
		geOpt.ifPresent(g -> {
			groupEntityService.deleteGroupEntity(g);
		});
	}
	
	@Test
	void testAddGroupEntityWithAttribute() {
		GroupEntity ge = new GroupEntity();
		GroupAttributeEntity gar = new GroupAttributeEntity();
		gar.setName("instance");
		gar.setValue("1");
		ge.getAttributes().add(gar);
		ge.setName(DEFAULT_GROUP_NAME);
		ge.setParentId(GroupEntity.TOP_PARENT_ID);
		ge.setRealm("connemat");
		ResponseEntity<?> response = groupEntityService.addGroupEntity(ge);
		System.err.println(response.getStatusCodeValue());
		assertTrue(response.getStatusCodeValue() == 201); //Response Empty
		Optional<GroupEntity> gePersisted = groupEntityService.findOne(Example.of(ge));
		assertTrue(gePersisted.isPresent());
	}
}
