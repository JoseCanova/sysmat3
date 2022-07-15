package br.com.connemat.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Validator;

import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.authorization.GroupPolicyRepresentation;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.connemat.model.api.ConnematResourcePermission;
import br.com.connemat.model.api.LoadedResourceValidationGroup;
import br.com.connemat.model.api.ResourceUriRole;
import br.com.connemat.rest.client.AdminRestClient;

@Service
@Profile(value = "keycloak")
public class SysmatKeyCloakUriRoleServiceImpl {

	@Autowired private AdminRestClient adminRestClient;
	
	@Autowired private Validator validator;

	public SysmatKeyCloakUriRoleServiceImpl() {
	}

	public List<ResourceUriRole> getAllValidSysmatClientResourceAssociatedUriRoles() { 
		
		ClientRepresentation sysmatClient = getSysmatClient();

		ResourceRepresentation[] rrs = adminRestClient.getResources(sysmatClient.getId());
		
		Stream<ResourceRepresentation> resourceRepresentationStream = Stream
																		.of(rrs);
		
		List<ResourceUriRole> rurs =  resourceRepresentationStream
										.map(resource -> toResourceUriRole(resource))
										.filter(resource -> validateResourceUri(resource , LoadedResourceValidationGroup.class))
										.collect(Collectors.toList());
		return rurs	
					.stream()
					.map(rur -> {
						List<ConnematResourcePermission> permissions = getClientResourcePermissions(sysmatClient.getId(), rur.getId());
						permissions
							.stream()
							.forEach(permission -> {
								      List<PolicyRepresentation> policies =  getAssociatedPolicies(sysmatClient.getId(), permission.getId());
								      policies
								      		.stream()
								      		.forEach(policy ->{
								      			if ("role".equals(policy.getType())) {
								      			RolePolicyRepresentation policyRole = getPolicyRoles(sysmatClient.getId(), policy.getId());
								      			Optional.ofNullable(policyRole)
								      							.ifPresent(r -> 
								      							{ 
								      									r.getRoles()
								      										.stream()
								      										.forEach(role -> {
										      									RoleRepresentation rrep = getRoleRepresentationById(role.getId());
										      									rur.addRole(rrep);
								      										});
								      							});
								      			}
								      			if ("group".equals(policy.getType())) {
								      				 GroupPolicyRepresentation groupPolicy = getPolicyGroups(sysmatClient.getId(), policy.getId());
								      				groupPolicy
								      				 	.getGroups()
								      				 	.stream()
								      				 	.forEach(grp ->{
								      				 		GroupRepresentation gp = getGroup(grp.getId());
								      				 		rur.addGroup(gp);
								      				 	});
								      			}
								      		});
							});
						return rur;
					})
					.collect(Collectors.toList());
	}

	private GroupRepresentation getGroup(String groupId) {
		return adminRestClient.getGroup(groupId);
	}

	private GroupPolicyRepresentation getPolicyGroups(String clientId, String policyId) {
		return adminRestClient.getPolicyGroups(clientId, policyId);
	}

	private boolean validateResourceUri(ResourceUriRole resource , Class<?> validationGroup) {
		return validator.validate(resource, validationGroup).size()==0;
	}

	private ResourceUriRole toResourceUriRole(ResourceRepresentation resource) {
		ResourceUriRole rur = new ResourceUriRole();
		rur.setId(resource.getId());
		rur.setName(resource.getName());
		rur.setUris(Optional
							  .ofNullable(resource.getUris())
							  .map(s -> s.stream().collect(Collectors.toList())).orElse(new ArrayList<>()));
		return rur;
	}

	private ClientRepresentation getSysmatClient() {
		List<ClientRepresentation> clients = adminRestClient.getClients();
		return getSysmatClient(clients);
	}
	
	private List<ConnematResourcePermission> getClientResourcePermissions(String clientId, String resourceId) {
		return adminRestClient
				.getClientResourcePermissions(clientId, resourceId);
	}
	

	private ClientRepresentation getSysmatClient(List<ClientRepresentation> clients) {
		return clients
				.stream()
				.filter(c -> {
					System.err.println(c.getClientId());
					return "sysmat".equals(c.getClientId());
				}).findFirst().get();
	}
	
	private List<PolicyRepresentation> getAssociatedPolicies(String clientId, String permissionId) {
		return adminRestClient.getAssociatedPolicies(clientId, permissionId);
	}

	private RolePolicyRepresentation getPolicyRoles(String clientId, String policyId) {
		return adminRestClient.getPolicyRoles(clientId , policyId);
	}
	
	private RoleRepresentation getRoleRepresentationById(String id) {
		return adminRestClient.getRoleRepresentationById(id);
	}
}
