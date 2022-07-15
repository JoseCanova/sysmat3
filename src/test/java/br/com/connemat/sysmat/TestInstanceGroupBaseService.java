package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.connemat.InstanceGroupBaseService;
import br.com.connemat.model.api.Group;

@SpringBootTest
public class TestInstanceGroupBaseService {

	@Autowired
	@Qualifier("instanceGroupBaseService")
	private InstanceGroupBaseService service;

	public TestInstanceGroupBaseService() {
	}

	@Test
	void testGetInstances() {
		assertNotNull(service);
		List<Group> instanceGroup = service.getInstances();
		assertNotNull(instanceGroup);
		assertTrue(instanceGroup.size() > 0);
	}

	@Test
	@WithMockUser(username="schindler_basic_user",roles={"USER","ADMIN"})
	void testGetUserInstances() {
		assertNotNull(service);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		assertNotNull(authentication);
		List<Group> groups = service.getUserInstances(authentication);
		assertNotNull(groups);
		assertTrue(groups.size() > 0);
	}

	@Test
	@WithMockUser(username="schindler_basic_user",roles={"USER","ADMIN"})
	void testGetUserInstanceSubGroups() {
		String baseGroupId = "938d95a0-6a7c-4f9a-9562-181bc6a7ecb9"; //groupbasico para teste.
		assertNotNull(service);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		assertNotNull(authentication);
		List<Group> groups = service.getUserInstanceSubGroups(authentication, baseGroupId);
		assertNotNull(groups);
		assertTrue(groups.size() > 0);
	}
	
}
