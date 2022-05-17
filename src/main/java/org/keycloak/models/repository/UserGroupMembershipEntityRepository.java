package org.keycloak.models.repository;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupMembershipEntityRepository
		extends JpaRepository<UserGroupMembershipEntity, UserGroupMembershipEntity.Key> {

	List<UserGroupMembershipEntity>findByUserId (String userId);
	
	Optional<UserGroupMembershipEntity> findByUserAndGroupId(UserEntity user , String groupId);
	
}
