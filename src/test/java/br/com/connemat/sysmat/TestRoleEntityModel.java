package br.com.connemat.sysmat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;

import br.com.connemat.model.api.Role;

@SpringBootTest
public class TestRoleEntityModel {

	public TestRoleEntityModel() {
	}

	
	@Test
	void testRoleEntityModel() {
		Role role = new Role();
		role.setId("thi_role_id");
		role.setName("thi_role_name");
		role.setDescription("the_role_description");
		EntityModel<Role> roleModel = EntityModel.of(role);
		System.err.println(roleModel.toString());
	}
	
}
