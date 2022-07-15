package br.com.connemat.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UserGroupBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserGroupRealm;
import br.com.connemat.rest.client.AdminRestClient;

@Service
@Validated
@Qualifier(value="userGroupBaseService")
@Primary
@Profile(value="keycloak")
public class UserGroupBaseServiceImpl implements UserGroupBaseService{

	@Autowired
	private AdminRestClient client;
	
	public UserGroupBaseServiceImpl() {
	}

	@Override
	public ResponseEntity<?> joinGroup(@NotEmpty String userId  ,   @NotEmpty String groupId , @Valid @NotNull UserGroupRealm ugr) {
		if(!groupId.equals(ugr.getGroupId()))
				throw new ConstraintViolationException(new HashSet<>());
		return client.joinGroup(ugr);
	}

	@Override
	public ResponseEntity<?> leaveGroup(@NotEmpty String userId  ,   @NotEmpty String groupId ) {
		return client.leaveGroup( userId  ,   groupId );
	}
	
	@Override
	public List<User> getGroupMembers(@NotEmpty String groupId) {
		return client.getGroupMembers(groupId);
	}

	@Override
	public List<Group> getUserGroups(@NotEmpty String userId) {
		return client.getUserGroups(userId);
	}

}
