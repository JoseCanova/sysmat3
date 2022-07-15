package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.keycloak.models.controller.services.UserEntityService;
import org.keycloak.models.repository.ClientEntityRepository;
import org.keycloak.models.repository.ResourceEntityRepository;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;
import org.keycloak.representations.idm.authorization.ResourcePermissionRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.connemat.controller.AuthServerController;
import br.com.connemat.model.api.ConnematResourcePermission;
import br.com.connemat.model.api.LoadedResourceValidationGroup;
import br.com.connemat.model.api.ResourceUriRole;
import br.com.connemat.model.api.RolesValidationGroup;
import br.com.connemat.rest.client.AdminRestClient;
import br.com.connemat.rest.client.model.AuthToken;
import br.com.connemat.rest.client.model.KeyCloakConfiguration;
import br.com.connemat.service.impl.SysmatKeyCloakUriRoleServiceImpl;


@SpringBootTest
class SysmatApplicationTests   {

	@Autowired private DataSource dataSource;
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext(name = "sysmat3")
	private EntityManager entityManager;
	
	@Autowired private AdminRestClient adminRestClient;

	@Autowired private KeyCloakConfiguration keyCloakConfiguration;
	
	@Autowired private AuthServerController authServerController;
	
	@Autowired private ClientEntityRepository clientEntityRepository;
	
	@Autowired private SysmatKeyCloakUriRoleServiceImpl sysmatKeyCloakUriRoleService;
	
	@Autowired private UserEntityService userEntityService; 
	
	@Autowired private Validator validator;
	
//	@Test
	void assertStartComponentsNotNull() { 
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
	}

//	@Test
	void assertRestClientGroupRepresentationNotNull() { 
		assertNotNull(adminRestClient);
		assertNotNull(adminRestClient.getGroups());
	}
	
//	@Test
	void assertTokenExchangeNotNull() { 
		assertNotNull(adminRestClient);
		AuthToken authToken = adminRestClient.exchangeAdminToken();
		assertNotNull(authToken);
		assertNotNull(authToken.getAccessToken());
		assertNotNull(authToken.getRefreshToken());
		assertNotNull(authToken.getExpiresIn());
		assertNotNull(authToken.getRefreshExpiresIn());
	}
	
//	@Test
	void assertKeyCloakConfigurationNotNull() { 
		assertNotNull(keyCloakConfiguration);
		assertNotNull(keyCloakConfiguration.getCredentialsSecret());
		assertNotNull(keyCloakConfiguration.getRealm());
		assertNotNull(keyCloakConfiguration.getCredentialsSecret().getSecret());
		assertNotNull(keyCloakConfiguration.getKeyCloakEndpoints());
		assertNotNull(keyCloakConfiguration.getKeyCloakEndpoints().getTokenUrl());
		assertNotNull(keyCloakConfiguration.getKeyCloakEndpoints().getUserUrl());
		assertNotNull(keyCloakConfiguration.getKeyCloakEndpoints().getGroupUrl());
		assertNotNull(keyCloakConfiguration.getTokenUrl());
		assertTrue(keyCloakConfiguration.getTokenUrl().contains(keyCloakConfiguration.getAuthServerUrl()));
		assertTrue(keyCloakConfiguration.getTokenUrl().contains(keyCloakConfiguration.getKeyCloakEndpoints().getTokenUrl()));
		assertNotNull(keyCloakConfiguration.getGroupUrl(false));
		assertTrue(keyCloakConfiguration.getGroupUrl(false).contains(keyCloakConfiguration.getAuthServerUrl()));
		assertTrue(keyCloakConfiguration.getGroupUrl(false).contains(keyCloakConfiguration.getKeyCloakEndpoints().getGroupUrl()));
		assertNotNull(keyCloakConfiguration.getUserUrl());
		assertTrue(keyCloakConfiguration.getUserUrl().contains(keyCloakConfiguration.getAuthServerUrl()));
		assertTrue(keyCloakConfiguration.getUserUrl().contains(keyCloakConfiguration.getKeyCloakEndpoints().getUserUrl()));
	}
	
//	@Test
	void assertRestClientWorkSpaceGroupRepresentationConfigured() { 
		assertNotNull(adminRestClient);
		List<GroupRepresentation> workspaces = adminRestClient.getWorkSpaceGroups();
		assertNotNull(workspaces);
		assertTrue(workspaces.size() >=1);
	}
	
//	@Test
//	void assertAuthConfigNotNull() { 
//		assertTrue(!authServerController.getAuthServerConfig().isEmpty());
//	}
	
//	@Test
	void assertClientEntityNotEmpty() { 
		assertNotNull(clientEntityRepository);
	}
	
	@Test
	void assertResourcesNotNull() {
		List<ClientRepresentation> clients = adminRestClient.getClients();
		ClientRepresentation sysmatClient = getSysmatClient(clients);
		ResourceRepresentation[] rep = adminRestClient.getResources(sysmatClient.getId());
		assertNotNull(rep);
		assertTrue(rep.length>0);
	}
	
	private ClientRepresentation getSysmatClient(List<ClientRepresentation> clients) {
		return clients
				.stream()
				.filter(c -> {
					System.err.println(c.getClientId());
					return "sysmat".equals(c.getClientId());
				}).findFirst().get();
	}

	@Test
	void assertKeyCloakClientsNotNull() {
		List<ClientRepresentation> clients = adminRestClient.getClients();
		assertNotNull(clients);
		assertTrue(clients.size()>0);
		List<ClientRepresentation> sysmatClientList = getSysmatClientList(clients);
		assertTrue(sysmatClientList.size()==1);
	}

	private List<ClientRepresentation> getSysmatClientList(List<ClientRepresentation> clients) {
		return clients
			.stream()
			.filter(c -> {
				System.err.println(c.getClientId());
				return "sysmat".equals(c.getClientId());
			}).collect(Collectors.toList());
	}
	
	@Test
	void assertAllSysmatClientResourcesPermissionsNotNull() {
		List<ClientRepresentation> clients = adminRestClient.getClients();
		ClientRepresentation sysmatClient = getSysmatClient(clients);
		ResourceRepresentation[] rep = adminRestClient.getResources(sysmatClient.getId());
		Stream
			.of(rep)
			.forEach(rp -> {
					List<ConnematResourcePermission> permissions = getClientResourcePermissions(sysmatClient.getId(), rp.getId()); 
					assertNotNull(permissions);
					assertTrue(permissions.size()>0);
					permissions.forEach(p -> System.err.println(p.getId()));
			});
	}
 
	ClientRepresentation getSysmatClient() {
		List<ClientRepresentation> clients = adminRestClient.getClients();
		return getSysmatClient(clients);
	}
	
	private List<ConnematResourcePermission> getClientResourcePermissions(String clientId, String resourceId) {
		return adminRestClient
				.getClientResourcePermissions(clientId, resourceId);
	}
	
	
	@Test
	void assertAllSysmatClientResourcesPermissionsPoliciesNotNull() {
		ClientRepresentation sysmatClient = getSysmatClient();
		ResourceRepresentation[] rep = adminRestClient.getResources(sysmatClient.getId());
		Stream
			.of(rep)
			.forEach(rp ->{
				List<ConnematResourcePermission> permissions = getClientResourcePermissions(sysmatClient.getId(), rp.getId()); 
				permissions
					.stream()
					.forEach(per -> 
									{
										List<PolicyRepresentation> policies = getAssociatedPolicies(sysmatClient.getId() , per.getId());
										assertNotNull(policies);
										assertTrue(policies.size()>0);
										policies.forEach(pol -> {
											System.err.println(pol.getId() + " " + pol.getName());
										});
									}
									);
			});
	}

	private List<PolicyRepresentation> getAssociatedPolicies(String clientId, String permissionId) {
		return adminRestClient.getAssociatedPolicies(clientId, permissionId);
	}
	
	@Test
	void assertAllSysmatClientResourceAssociatedPoliciesNotNull() { 
		ClientRepresentation sysmatClient = getSysmatClient();
		Stream
				.of(adminRestClient.getResources(sysmatClient.getId()))
				.map(rp -> getClientResourcePermissions(sysmatClient.getId(), rp.getId()))
				.forEach(permissionList -> {
					permissionList
							.stream()
							.forEach(per -> {
								getAssociatedPolicies(sysmatClient.getId() , per.getId())
											  .stream()
											  .forEach(pol -> {
												         List<PolicyRepresentation> policyRepresentationList = getAssociatedPolicies(sysmatClient.getId() , per.getId());
												         assertNotNull(policyRepresentationList); 
												         policyRepresentationList
												         	.stream()
												         	.filter(pr -> "role".equals(pr.getType()))
												         	.forEach(polr -> {
												         		System.err.println("Police Repreentation of type role associated " + polr.getId() + ' ' + polr.getName());
												         		RolePolicyRepresentation response = getPolicyRoles(sysmatClient.getId() , polr.getId());
												         		System.err.println("The problematic response " + response.getId());
												         		assertNotNull(response);
												         	});
												         //assertTrue(roles.size()>0);
											  });
							});
				});
	}
	
	@Test
	void assertAllSysmatClientResourceAssociatedRolesNotNull() { 
		ClientRepresentation sysmatClient = getSysmatClient();
		Stream
				.of(adminRestClient.getResources(sysmatClient.getId()))
				.map(rp -> getClientResourcePermissions(sysmatClient.getId(), rp.getId()))
				.forEach(permissionList -> {
					permissionList
							.stream()
							.forEach(per -> {
								getAssociatedPolicies(sysmatClient.getId() , per.getId())
											  .stream()
											  .forEach(pol -> {
												         List<PolicyRepresentation> policyRepresentationList = getAssociatedPolicies(sysmatClient.getId() , per.getId());
												         assertNotNull(policyRepresentationList); 
												         policyRepresentationList
												         	.stream()
												         	.filter(pr -> "role".equals(pr.getType()))
												         	.forEach(polr -> {
												         		System.err.println("Police Representation of type role associated " + polr.getId() + ' ' + polr.getName());
												         		RolePolicyRepresentation response = getPolicyRoles(sysmatClient.getId() , polr.getId());
												         		System.err.println("The problematic response " + response.getId());
												         		assertNotNull(response);
												         		Set<RolePolicyRepresentation.RoleDefinition> roles = response.getRoles(); 
												         		roles
												         			.stream()
												         			.forEach(rr ->{
												         				RoleRepresentation ror = getRoleRepresentationById(rr.getId());
												         				assertNotNull(ror);
												         				assertTrue(assertNotEmpty(ror.getId()));
												         			});
												         	});
											  });
							});
				});
	}

	@Test
	void testSysmatUriRoleService() { 
		List<?> theSysmatResourceUriRoleList = sysmatKeyCloakUriRoleService.getAllValidSysmatClientResourceAssociatedUriRoles();
		assertNotNull(theSysmatResourceUriRoleList);
		assertTrue(theSysmatResourceUriRoleList.size()>0);
	}
	
	@Test 
	void testUriRoleClassInvalid() {
		ResourceUriRole theRole = new ResourceUriRole(); 
		assertTrue(validator.validate(theRole , LoadedResourceValidationGroup.class).size() == 3);
		theRole.setId("id");
		assertTrue(validator.validate(theRole , LoadedResourceValidationGroup.class).size() == 2);
		theRole.setName("the Name");
		assertTrue(validator.validate(theRole , LoadedResourceValidationGroup.class).size() == 1);
		List<String> urList = new ArrayList<>();
		urList.add("Simple Value");
		theRole.setUris(urList);
		assertTrue(validator.validate(theRole , LoadedResourceValidationGroup.class).size() == 0);
		assertTrue(validator.validate(theRole , RolesValidationGroup.class).size() == 1);
		List<String> roleList = new ArrayList<>();
		roleList.add("Role Value");
		theRole.setRoles(roleList);
		assertTrue(validator.validate(theRole , RolesValidationGroup.class).size() == 0);
	}
	
	private boolean assertNotEmpty(String id) {
		return id !=null && !id.isEmpty() ? true :false;
	}

	private RoleRepresentation getRoleRepresentationById(String id) {
		return adminRestClient.getRoleRepresentationById(id);
	}

	private RolePolicyRepresentation getPolicyRoles(String clientId, String policyId) {
		return adminRestClient.getPolicyRoles(clientId , policyId);
	}
	
	@Test
	void assertFindByIdPositive() {
		Optional<?> result = userEntityService.findByUsernameOrEmailAndRealmId("jcanova" , "connemat");
		assertTrue(result.isPresent());
	}
}
