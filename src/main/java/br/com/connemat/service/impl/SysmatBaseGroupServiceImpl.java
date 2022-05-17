package br.com.connemat.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.keycloak.models.controller.services.UserGroupMembershipEntityService;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.keycloak.models.utils.GroupEntityGroupConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.GroupBaseService;
import br.com.connemat.SysmatBaseGroupService;
import br.com.connemat.UserBaseService;
import br.com.connemat.model.api.Group;

@Service
@Qualifier(value="sysmatBaseGroupService")
@Primary
@Validated
public class SysmatBaseGroupServiceImpl implements SysmatBaseGroupService {

	@Autowired
	private GroupBaseService groupEntityService;
	
	@Autowired 
	private UserBaseService userEntityService;

	@Autowired 
	private UserGroupMembershipEntityService userGroupMembershipEntityService;
	
	@Autowired
	private GroupEntityGroupConverter groupEntityConverter;
	
	public SysmatBaseGroupServiceImpl() {
	}

	@Override
	@Transactional("keycloak-tm")
	public List<Group> getSysmatGroups() {
		return  groupEntityService
				.findByAttributesNameAndRealm(SYSMAT_USER_GROUP, DEFAULT_REALM_ID)
				.stream()
				.map(ge ->{
					return groupEntityConverter.convert(ge);
				}).collect(Collectors.toList());
	}

	@Override
	@Transactional("keycloak-tm")
	public List<Group> getSysmatUserGroups(@NotNull Authentication authentication) {
		Optional<UserEntity> user = userEntityService.getByUserAndRealmId(authentication.getName(), DEFAULT_REALM_ID);
		return user.
				map(u -> {
					List<UserGroupMembershipEntity> userGroups = userGroupMembershipEntityService.findByUserId(u.getId());
					return userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
				})
				.map(gIds -> {
						List<GroupEntity> ges = groupEntityService.findByIdInAndAttributesName(gIds ,SYSMAT_USER_GROUP);
						return ges;})
				.map(ge -> fromGroupEntity(ge))
				.orElseThrow(RuntimeException::new);
	}

	private List<Group> fromGroupEntity(List<GroupEntity> ge) {
		return ge.stream().map(g -> groupEntityConverter.convert(g)).collect(Collectors.toList());
	}

}
