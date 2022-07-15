package br.com.connemat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.UserGroupBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserGroupRealm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/user-groups")
@Profile(value="keycloak")
public class UserGroupController {

	@Autowired
	@Qualifier("userGroupBaseService")
	private UserGroupBaseService userGroupBaseService;

	public UserGroupController() {
	}

	@PutMapping(path="/{userId}/{groupId}")
	public ResponseEntity<?> joinGroup(@PathVariable(name = "userId" , required = true)String userId  ,   @PathVariable(name = "groupId" , required = true)String groupId  , @RequestBody UserGroupRealm ugr){
		return userGroupBaseService.joinGroup(userId , groupId ,  ugr);
	}

	@DeleteMapping(path="/{userId}/{groupId}")
	public ResponseEntity<?> leaveGroup(@PathVariable(name = "userId")String userId  ,   @PathVariable(name = "groupId") String groupId ){
		return userGroupBaseService.leaveGroup(userId , groupId);
	}

	@GetMapping (path="/{groupId}/members")
	public ResponseEntity<List<User>> getGroupMembers (@PathVariable(name="groupId") String groupId){
		return ResponseEntity.ok(userGroupBaseService.getGroupMembers(groupId));
	}

	@GetMapping (path="/{userId}/groups")
	public ResponseEntity<List<Group>> getUserGroups(@PathVariable(name="userId") String userId){
		return ResponseEntity.ok(userGroupBaseService.getUserGroups(userId));
	}

}
