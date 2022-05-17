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

import br.com.connemat.SysmatBaseGroupService;
import br.com.connemat.model.api.Group;

@SpringBootTest
public class TestSysmatBaseGroupService {

	@Autowired
	@Qualifier("sysmatBaseGroupService")
	private SysmatBaseGroupService sysmatBaseGroupService;

	public TestSysmatBaseGroupService() {
	}

	@Test
	void testGetSysmatGroups() {
		assertNotNull(sysmatBaseGroupService);
		List<Group> groups = sysmatBaseGroupService.getSysmatGroups();
		assertNotNull(groups);
	}

	@Test
	@WithMockUser(username="schindler_basic_user",roles={"USER","ADMIN"})
	void testGetSysmatUserGroups() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		assertNotNull(authentication);
		assertNotNull(sysmatBaseGroupService);
		List<Group> groups = sysmatBaseGroupService.getSysmatUserGroups(authentication);
		assertNotNull(groups);
		assertNotNull(groups.size() > 0);
	}

	@Test
	@WithMockUser(username="teste",roles={"USER","ADMIN"})
	void testGetSysmatUserNoGroups() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		assertNotNull(authentication);
		assertNotNull(sysmatBaseGroupService);
		List<Group> groups = sysmatBaseGroupService.getSysmatUserGroups(authentication);
		assertNotNull(groups);
		assertTrue(groups.size() == 0);
	}

}
