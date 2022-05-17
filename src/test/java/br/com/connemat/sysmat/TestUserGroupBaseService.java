package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.GroupBaseService;
import br.com.connemat.UserGroupBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.validation.GroupUpdateValidation;
import br.com.connemat.model.api.validation.UserUpdateValidationGroup;


@SpringBootTest
public class TestUserGroupBaseService {

	public static final String USER = "756d7814-db3f-472d-aca2-4d020c111d1a";
	
	public static final String GROUP = "7b94441e-b3b0-4e73-aaa5-84ed8a5d9648";
	
	@Autowired 
	@Qualifier("groupEntityService")
	private GroupBaseService service;
	
	@Autowired
	@Qualifier("userGroupBaseService")
	private UserGroupBaseService userGroupService; 
	
	@Autowired
	private Validator validator;
	
	public TestUserGroupBaseService() {
	}

	
	@Test
	void testGetUserGroupMembers() {
		List<Group> groups = service.getAllGroups();
		groups
		.stream()
		.forEach(g ->{
			List<User> list = userGroupService.getGroupMembers(g.getId());
			assertNotNull(list);
			if (list.size() > 0) {
				list.stream().forEach(e -> validateUser(e));
			}
		});
	}
	
	@Test
	void testGetGroupMembers() {
		List<User> users = userGroupService.getGroupMembers(GROUP);
		assertNotNull(users);
		assertTrue(users.size()>0);
		users.stream().forEach(u ->{validateUser(u);});
	}
	
	@Test
	void testGetUserGroups() {
		List<Group> groups = userGroupService.getUserGroups(USER);
		assertNotNull(groups);
		assertTrue(groups.size()>0);
		groups.stream().forEach(g ->{validateGroup(g);});
	}

	private void validateUser(User e) {
		Set<?> violations = validator.validate(e, UserUpdateValidationGroup.class);
		assertTrue(violations.size() == 0);
	}
	
	private void validateGroup(Group e) {
		Set<?> violations = validator.validate(e, GroupUpdateValidation.class);
		assertTrue(violations.size() == 0);
	}

}
