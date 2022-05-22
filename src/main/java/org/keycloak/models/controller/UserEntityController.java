package org.keycloak.models.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.keycloak.models.controller.services.UserGroupMembershipEntityService;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.GroupBaseService;
import br.com.connemat.UserBaseService;
import br.com.connemat.rest.client.model.IdRepresentation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/user_entity", 
produces = MediaType.APPLICATION_JSON_VALUE )
@Profile(value="keycloak")
public class UserEntityController {

	@Autowired
	private UserBaseService userEntityservice;
	
	@Autowired 
	private GroupBaseService groupEntityService;
	
	@Autowired 
	private UserGroupMembershipEntityService groupMembershipEntityService;
	
	public UserEntityController() {
	}
	
	@GetMapping(path="/data/{id}/{realmId}")
	public Optional<IdRepresentation> getByNameOrEmailAndRealmId(@PathVariable(name = "id")String id , @PathVariable(name="realmId") String realmId){ 
	return userEntityservice.findByUsernameOrEmailAndRealmId(id , realmId);
	}
	
	
	@GetMapping(path="/email/{email}/{realmId}")
	public Optional<UserEntity> getByEmailAndRealmId(@PathVariable(name = "email")String email 
				, @PathVariable(name="realmId") String realmId){ 
		return userEntityservice.findByEmailAndRealmId(email, realmId);
	}
	
	@GetMapping(path="/username/{username}/{realmId}")
	public Optional<UserEntity> getByUsernameAndRealmId(@PathVariable(name = "username")String username 
						, @PathVariable(name="realmId") String realmId){ 
		return userEntityservice.findByUsernameAndRealmId(username, realmId);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UserEntity> getUserById(@PathVariable(name = "id" )  String userId){ 
		return userEntityservice.findById(userId);
	}

	@GetMapping(path = "/{id}/groups")
	public List<GroupEntity> getUserGroups(@PathVariable(name = "id" ) String userId){ 
		List<UserGroupMembershipEntity> userGroups = groupMembershipEntityService.findByUserId(userId);
		List<String> groupIds = userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
		return groupEntityService.findByIdIn(groupIds);
	}

	@GetMapping(path = "/{realmId}/{userId}/workspaces")
	@Transactional("keycloak-tm")
	public List<GroupEntity> getUserWorkspaces(@PathVariable(name = "userId" )  String userId 
					, @PathVariable(name="realmId")String realmId){ 
		Optional<UserEntity> user = getByUserAndRealmId(userId, realmId);
		return user.
		map(u -> {
			List<UserGroupMembershipEntity> userGroups = groupMembershipEntityService.findByUserId(u.getId());
			return userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
		})
		.map(gIds -> groupEntityService.findByIdInAndAttributesName(gIds , "instance"))
		.orElseThrow(RuntimeException::new);
	}
	
	@Transactional("keycloak-tm")
	private Optional<UserEntity> getByUserAndRealmId(@PathVariable(name = "user")String user 
					, @PathVariable(name="realmId") String realmId){ 
					Optional<UserEntity> userEntity = userEntityservice.findByUsernameAndRealmId(user, realmId);
					if (!userEntity.isPresent())
						userEntity = userEntityservice.findByEmailAndRealmId(user, realmId);
					return userEntity;
	}
}
