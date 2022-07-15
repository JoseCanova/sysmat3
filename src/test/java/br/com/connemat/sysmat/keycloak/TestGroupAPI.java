package br.com.connemat.sysmat.keycloak;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.GroupBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.GroupAttribute;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.validation.GroupAttributeValidation;
import br.com.connemat.model.api.validation.GroupUpdateValidation;
import br.com.connemat.model.api.validation.UserUpdateValidationGroup;

@SpringBootTest
public class TestGroupAPI {

	@Autowired
	@Qualifier("groupEntityService")
	private GroupBaseService service;
	
	@Autowired
	private Validator validator;
	
	public TestGroupAPI() {
	}

	@Test
	void testGetGroups() {
		List<Group> groups = service.getAllGroups();
		assertTrue(groups.size()>0);
		assertValid(groups);
	}
	
	@Test
	void addGroup() {
		Group group  = createBaseValidGroup();
		Group theGroup = service.addGroup(group);
		validator.validate(theGroup, GroupUpdateValidation.class ,  Default.class , GroupAttributeValidation.class);	
		service.deleteGroup(theGroup.getId());
	}
	
	@Test
	void addSubGroup() {
		List<Group> groups = service.getGroups("schindler");
		String id = groups
		.stream()
		.findAny()
		.map(g -> g.getId())
		.orElseThrow(RuntimeException::new);
		Group group = createBaseValidGroup();
		Group subGroup = service.addSubGroup(id, group);
		service.deleteGroup(subGroup.getId());
	}

	private Group createBaseValidGroup() {
		Group group = new Group();
		group.setName("default_create_group");
		group.setAttributes(createAttribute());
		return group;
	}

	private List<GroupAttribute> createAttribute() {
		List<GroupAttribute> grs = new ArrayList<>();
		GroupAttribute ga = new GroupAttribute();
		ga.setName("instance");
		ga.setValue("1");
		grs.add(ga);
		return grs;
	}

	private void assertValid(List<Group> groups) {
		groups
		.stream()
		.forEach(g ->{
			validate(g);
		});
	}

	private void validate(Group g) {
		Set<?> constraints =  validator.validate(g, Default.class , GroupUpdateValidation.class);
		assertTrue(constraints.size() == 0);
	}
	
}
