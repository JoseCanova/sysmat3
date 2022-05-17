package org.keycloak.models.utils;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.Group;

@Component
public class GroupEntityGroupConverter extends Converter<GroupEntity , Group>{

	@Autowired 
	private GroupEntityRepresentationConverter representationConverter;
	
	@Autowired 
	private GroupRepresentationGroupConverter entityConverter;
	
	public GroupEntityGroupConverter() {
	}

	@Override
	public Group doForward(GroupEntity a) {
		return entityConverter.convert(representationConverter.convert(a));
	}

	@Override
	public GroupEntity doBackward(Group b) {
		return null;
	}

}
