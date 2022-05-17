package br.com.connemat.sysmat.keycloak;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.keycloak.models.jpa.entities.RoleAttributeEntity;
import org.keycloak.models.jpa.entities.RoleEntity;
import org.keycloak.models.repository.RoleAttributeEntityRepositoy;
import org.keycloak.models.repository.RoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import br.com.connemat.model.api.ResourceUriRole;
import br.com.connemat.service.impl.SysmatKeyCloakUriRoleServiceImpl;

@SpringBootTest
public class TestRoleEntity {
	
	public final String SYSMAT_ACTION_NAME =  "sysmat-action";

	@Autowired private SysmatKeyCloakUriRoleServiceImpl sysmatKeyCloakUriRoleService;
	
	@Autowired private RoleEntityRepository roleEntityRepository;
	
	@Autowired private RoleAttributeEntityRepositoy roleAttributeEntityRepository;
	
	@Test
	void assertResourceRoleConfiguration() {
		assertNotNull(sysmatKeyCloakUriRoleService);
		List<ResourceUriRole> resources = sysmatKeyCloakUriRoleService.getAllValidSysmatClientResourceAssociatedUriRoles();
		assertNotNull(resources);
		resources.stream().forEach( r -> {
			System.err.println(r.getUris().toString() + " " + r.getRoles().toString());
		});
	}
	
	@Test 
	void assertQueryResultRoleAttributeEntity() {
		RoleAttributeEntity rae = new RoleAttributeEntity(); 
		rae.setName(SYSMAT_ACTION_NAME);
		RoleEntity re = new RoleEntity();
		re.getAttributes().add(rae);
		Example<RoleAttributeEntity> ex = Example.of(rae);
		List<RoleAttributeEntity> list = roleAttributeEntityRepository.findAll(ex);
		list
		.stream()
		.forEach(r -> {
			System.err.println(r.getRole());
		});
	}
	
}
