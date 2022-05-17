package br.com.connemat.sysmat.keycloak;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.keycloak.models.utils.GroupRepresentationGroupConverter;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.validation.GroupUpdateValidation;
import br.com.connemat.model.api.validation.RealmRoleValidation;
import br.com.connemat.model.api.validation.SubGroupValidation;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestGroupRepresentationGroupConverter {

	public static final String ID = "id_representation";
	
	public static final String ID_SUBGROUP = "subid_representation";
	
	public static final String NAME = "name_representation";

	public static final String NAME_SUBGROUP = "subgroupname_representation";

	public static final String PATH = "path_representation";
	
	public static final String PATH_SUBGROUP = "subgrouppath_representation";
	
	@Autowired
	private GroupRepresentationGroupConverter converter;
	
	@Autowired
	private Validator validator;
	
	public TestGroupRepresentationGroupConverter() {
	}

	@Test
	void testGroupRepresentationConverter() {
		GroupRepresentation gr = new GroupRepresentation();
		gr.setId(ID);
		gr.setName(NAME);
		gr.setPath(PATH);
		createRealmRoles(gr);
		createSubGroup(gr);
		Group group = converter.convert(gr);
		assertValid(group);
		assertValidRealmRoles(group);
		assertValidSubGroups(group);
	}

	private void createSubGroup(GroupRepresentation gr) {
		GroupRepresentation gr1 = new GroupRepresentation();
		gr1.setId(ID_SUBGROUP);
		gr1.setName(NAME_SUBGROUP);
		gr1.setPath(PATH_SUBGROUP);
		createRealmRoles(gr1);
		List<GroupRepresentation> grs = new ArrayList<>();
		grs.add(gr1);
		gr.setSubGroups(grs);
	}

	private void createRealmRoles(GroupRepresentation gr) {
		List<String> realmRoles = new ArrayList<>();
		realmRoles.add("role1");
		gr.setRealmRoles(realmRoles);
	}

	private void assertValid(Group group) {
		Set<ConstraintViolation<Group>> set = validator.validate(group, GroupUpdateValidation.class , Default.class);
		assertTrue(set.size()==0);
	}
	
	private void assertValidRealmRoles(Group group) {
		Set<ConstraintViolation<Group>> set = validator.validate(group, RealmRoleValidation.class , Default.class);
		assertTrue(set.size()==0);
	}

	private void assertValidSubGroups(Group group) {
		Set<ConstraintViolation<Group>> set = validator.validate(group, SubGroupValidation.class);
		assertTrue(set.size()==0);
	}
	
}
