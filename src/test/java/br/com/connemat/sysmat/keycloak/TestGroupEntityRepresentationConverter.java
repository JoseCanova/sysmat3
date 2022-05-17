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
import org.keycloak.models.utils.GroupEntityRepresentationConverter;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class TestGroupEntityRepresentationConverter {

	@Autowired private GroupEntityService groupEntityService;
	
	@Autowired private RealmEntityService realmEntityService;
	
	public static final String DEFAULT_GROUP_NAME =  "GroupNameTherapy";
	
	@Test
	void textAddGroup() {
		GroupEntity ge = createBaseGroupEntity();
		ResponseEntity<?> ret = groupEntityService.addGroupEntity(ge);
		assertNotNull(ret);
	}
	
	@Test
	void testConvertGroupEntityRepresentation() {
		GroupEntityRepresentationConverter ger = new GroupEntityRepresentationConverter();
		GroupEntity ge = createBaseGroupEntity();
		GroupRepresentation gr = ger.convert(ge);
		assertNotNull(gr.getName());
		assertNotNull(gr.getPath());
		assertTrue(gr.getAttributes().size()>0);
	}

	private GroupEntity createBaseGroupEntity() {
		Optional<RealmEntity> re = realmEntityService.findById("connemat");
		GroupEntity ge = new GroupEntity();
		ge.setName(DEFAULT_GROUP_NAME);
		ge.setRealm(re.get().getName());
		createBaseAttributes(ge);
		return ge;
	}

	private void createBaseAttributes(GroupEntity ge) {
		GroupAttributeEntity gae = new GroupAttributeEntity();
		gae.setName("name");
		gae.setValue("value");
		ge.getAttributes().add(gae);
	}

}
