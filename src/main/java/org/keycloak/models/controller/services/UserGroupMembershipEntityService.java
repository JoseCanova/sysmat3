package org.keycloak.models.controller.services;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.keycloak.models.repository.UserGroupMembershipEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserGroupMembershipEntityService {

	@Autowired 
	private UserGroupMembershipEntityRepository repository;
	
	public UserGroupMembershipEntityService() {
	}

	@Transactional("keycloak-tm")
	public List<UserGroupMembershipEntity> findByUserId(String id) {
		return repository.findByUserId(id);
	}

	public Optional<UserGroupMembershipEntity> findByUserAndGroupId(UserEntity user, String groupId) {
		return repository.findByUserAndGroupId(user, groupId);
	}
	
}
