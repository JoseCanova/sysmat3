package br.com.connemat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.keycloak.models.controller.services.UserGroupMembershipEntityService;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.jpa.entities.UserGroupMembershipEntity;
import org.keycloak.models.utils.GroupEntityGroupConverter;
import org.keycloak.models.utils.GroupRepresentationGroupConverter;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.GroupBaseService;
import br.com.connemat.InstanceGroupBaseService;
import br.com.connemat.UserBaseService;
import br.com.connemat.model.api.Group;
import br.com.connemat.rest.client.AdminRestClient;

@Service
@Qualifier(value="instanceGroupBaseService")
@Primary
@Validated
@Profile(value="keycloak")
public class InstanceGroupBaseServiceImpl implements InstanceGroupBaseService {

	@Autowired 
	private GroupBaseService groupEntityService;
	
	@Autowired 
	private UserBaseService userEntityService;
	
	@Autowired 
	private UserGroupMembershipEntityService userGroupMembershipEntityService;
	
	@Autowired
	private AdminRestClient restClient;
	
	@Autowired
	private GroupEntityGroupConverter groupEntityConverter;

	@Autowired
	private GroupRepresentationGroupConverter groupRepresentationConverter;

	public InstanceGroupBaseServiceImpl() {
	}

	@Override
	public List<Group> getInstances() {
		return groupEntityService.getGroupsBytAttributeName(DEFAULT_REALM_ID, INSTANCE);
	}

	@Override
	public List<Group> getInstanceGroups(@NotEmpty String instanceGroupId) {
		return restClient.getGroup(instanceGroupId).getSubGroups().stream().map(sg -> fromGroupRepresentation(sg)).collect(Collectors.toList());
	}

	private Group fromGroupRepresentation(GroupRepresentation sg) {
		return groupRepresentationConverter.convert(sg);
	}

	@Override
	public List<Group> getUserInstances(@NotNull Authentication authentication) {
		Optional<UserEntity> user = userEntityService.getByUserAndRealmId(authentication.getName(), DEFAULT_REALM_ID);
		return user.
				map(u -> {
					List<UserGroupMembershipEntity> userGroups = userGroupMembershipEntityService.findByUserId(u.getId());
					return userGroups.stream().map(ug -> ug.getGroupId()).collect(Collectors.toList());
				})
				.map(gIds -> {
						List<GroupEntity> ges = groupEntityService.findByIdInAndAttributesName(gIds ,INSTANCE);
						return ges;})
				.map(ge -> fromGroupEntity(ge))
				.orElseThrow(RuntimeException::new);
	}

	private List<Group> fromGroupEntity(List<GroupEntity> ge) {
		return ge.stream().map(g -> groupEntityConverter.convert(g)).collect(Collectors.toList());
	}

	@Override
	public List<Group> getUserInstanceSubGroups(@NotNull Authentication authentication, @NotEmpty String instanceGroupId) {
		List<Group> userInstanceSubGroups = new ArrayList<>();
		Optional<UserEntity> userOpt = userEntityService.getByUserAndRealmId(authentication.getName(), DEFAULT_REALM_ID);
		Optional<UserGroupMembershipEntity> memberOpt =  userGroupMembershipEntityService.findByUserAndGroupId(userOpt.get(), instanceGroupId);
		memberOpt.map(um ->{
			return  groupEntityService.getGroup(instanceGroupId).getSubGroups();
		}).ifPresent(lsg ->{
			lsg.stream().forEach(sg ->{
				Optional<UserGroupMembershipEntity> usgOpt =  userGroupMembershipEntityService.findByUserAndGroupId(userOpt.get(), sg.getId());
				usgOpt.ifPresent(usg ->{
					Group subGroup = groupEntityService.getGroup(usg.getGroupId());
					userInstanceSubGroups.add(subGroup);
				});
			});
		});
		return userInstanceSubGroups;
	}

}