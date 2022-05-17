package br.com.connemat.sysmat;

import java.util.List;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.connemat.RoleBaseService;
import br.com.connemat.model.api.Role;
import br.com.connemat.model.api.RolesValidationGroup;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestRoleBaseService {

	public static final String CLIENT_ID = "716a4138-17e1-4771-b71d-655633df473b";

	@Autowired
	private Validator validator;
	
	@Autowired
	@Qualifier("roleBaseService")
	private RoleBaseService roleBaseService;
	
	public TestRoleBaseService() {
	}
	
	@Test
	void testeGetAllRoles() {
		assertNotNull(roleBaseService);
		List<Role>roles = roleBaseService.getRoles(CLIENT_ID);
		assertNotNull(roles);
		assertTrue(roles.size()>0);
		roles
		.stream()
		.forEach(r ->{
			validateRole(r);
		});
	}

	@Test
	void testGetRoleByName() {
		String roleName = "item:view";
		Role role = roleBaseService.getRoleByName(CLIENT_ID, roleName);
		assertNotNull(role);
		System.err.println(role.toString());
	}

	@Test
	void testeCreateRole() {
		assertNotNull(roleBaseService);
		ResponseEntity<?> response = roleBaseService.createRole(CLIENT_ID, createBaseRole());
		assertTrue(response.getStatusCodeValue()==201);
	}

	private void validateRole(Role r) {
		System.err.println(r.toString());
		Set<?> v =  validator.validate(r, RolesValidationGroup.class , Default.class);
		assertTrue(v.size()==0);
	}

	Role createBaseRole() {
		Role role = new Role();
		role.setName("the_base_role");
		role.setClientRole(true);
		role.setDescription("the_base_description");
		return role;
	}
	
}