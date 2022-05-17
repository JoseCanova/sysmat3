package br.com.connemat;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserGroupRealm;

public interface UserGroupBaseService {

	ResponseEntity<?> joinGroup(@NotEmpty String userId, @NotEmpty  String groupId, @Valid @NotNull UserGroupRealm ugr);

	ResponseEntity<?> leaveGroup(@NotEmpty String userId, @NotEmpty  String groupId);

	List<User> getGroupMembers(@NotEmpty String groupId);
	
	List<Group> getUserGroups(@NotEmpty String userId);
	
}