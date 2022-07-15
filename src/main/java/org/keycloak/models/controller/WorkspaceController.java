package org.keycloak.models.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.keycloak.models.UserRealmRepresentation;
import org.keycloak.models.controller.services.UserGroupMembershipEntityService;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.GroupBaseService;
import br.com.connemat.UserBaseService;
import br.com.connemat.rest.client.model.WorkspaceRepresentation;

@RestController 
@RequestMapping(
		path="/workspaces", 
		produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin("*")
@Profile(value="keycloak")
public class WorkspaceController {

	@Autowired 
	@Qualifier("JacksonJsonParser") 
	private JsonParser jsonParser; 
	
	@Autowired 
	private UserBaseService userEntityService;
	
	@Autowired 
	private GroupBaseService groupEntityService;
	
	@Autowired 
	private UserGroupMembershipEntityService userGroupMembershipEntityService;
	
	public WorkspaceController() {
	}

	@GetMapping
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> getWorkspaces(){ 
		return toWorkspaceList(groupEntityService
				.findByAttributesName("instance"));
	}
	
	@PostMapping
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> postWorkspaces(){ 
		return toWorkspaceList(groupEntityService
				.findByAttributesName("instance"));
	}
	
	@PutMapping
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> putWorkspaces(){ 
		return toWorkspaceList(groupEntityService
				.findByAttributesName("instance"));
	}
	
	@DeleteMapping
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> delWorkspaces(){ 
		return toWorkspaceList(groupEntityService
				.findByAttributesName("instance"));
	}
	
	@GetMapping(path = "/{realmId}")
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> getRealmWorkspaces(@PathVariable(name="realmId")String realmId){ 
		return toWorkspaceList(
				groupEntityService
				.findByAttributesNameAndRealm("instance", realmId));
	}

	@GetMapping(path = "/{realmId}/{userId}")
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> getRealmUserWorkspaces(@PathVariable(name = "userId" )  String userId 
					, @PathVariable(name="realmId") String realmId 
					, @CurrentSecurityContext(expression = "authentication") Authentication authentication){ 

		Optional<UserEntity> user = userEntityService
									.getByUserAndRealmId(authentication.getName(), realmId);
		return user.
		map(u -> {
			List<UserGroupMembershipEntity> userGroups = userGroupMembershipEntityService.findByUserId(u.getId());
			return userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
		})
		.map(gIds -> groupEntityService.findByIdInAndAttributesName(gIds , "instance"))
		.map(ge -> toWorkspaceList(ge))
		.orElseThrow(RuntimeException::new);
	}
	
	
	@PostMapping(path = "/user_instances")
	@Transactional("keycloak-tm")
	public List<WorkspaceRepresentation> getRealmUserWorkspaces(@RequestBody UserRealmRepresentation userRealm,
																@CurrentSecurityContext(expression = "authentication") Authentication authentication){ 

		Optional<UserEntity> user = userEntityService
									.getByUserAndRealmId(authentication.getName(), userRealm.getRealmId());
		return user.
		map(u -> {
			List<UserGroupMembershipEntity> userGroups = userGroupMembershipEntityService.findByUserId(u.getId());
			return userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
		})
		.map(gIds -> groupEntityService.findByIdInAndAttributesName(gIds , "instance"))
		.map(ge -> toWorkspaceList(ge))
		.orElseThrow(RuntimeException::new);
	}

	
	private List<WorkspaceRepresentation> toWorkspaceList(List<GroupEntity> gel) {
		return gel
				.stream()
				.map(ge->toWorkspace(ge))
				.collect(Collectors.toList());
	}

	private WorkspaceRepresentation toWorkspace(GroupEntity ge) {
		return new WorkspaceRepresentation(ge.getId() , ge.getName());
	}
}
