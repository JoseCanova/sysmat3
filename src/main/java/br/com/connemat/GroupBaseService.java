package br.com.connemat;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;

import br.com.connemat.model.api.Group;

public interface GroupBaseService {
	
	List<Group> getAllGroups();

	List<Group> getGroups( String searchString);
	
	List<Group> getGroups( String searchString,  String attributeName );
	
	Group addGroup( Group group);

	Group getGroup( String id);
	
	List<Group> getGroupsBytAttributeName( String realmId  ,  String attributeName);
	
	List<Group> getUserGroupsBytAttributeName( String attributeName  , @CurrentSecurityContext(expression = "authentication") Authentication authentication);

	void deleteGroup( String id);

	Group updateGroup( String id,  Group group);
	
	Group addSubGroup( String id,  Group group);

	Optional<GroupEntity> findOne(Example<GroupEntity> of);

	ResponseEntity<?> addGroupEntity(GroupEntity ge);

	List<GroupEntity> findByAttributesName(String string);

	 List<GroupEntity>  findByIdInAndAttributesName(List<String> gIds, String string);

	List<GroupEntity> findByAttributesNameAndRealm(String string, String realmId);

	List<GroupEntity> findByIdIn(List<String> groupIds);

	List<GroupEntity> findByRealm(String realm);

}
