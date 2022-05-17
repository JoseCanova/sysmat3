package org.keycloak.models.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.keycloak.models.jpa.entities.GroupAttributeEntity;
import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

@Component
public class GroupEntityRepresentationConverter extends Converter<GroupEntity , GroupRepresentation>{

	//TODO: implementar recursividade path parent.
	@Override
	protected GroupRepresentation doForward(GroupEntity a) {
		GroupRepresentation gr = new GroupRepresentation();
		gr.setName(a.getName());
		Optional
			.ofNullable(a.getParentId())
			.map(g ->{
				StringBuilder sb = new StringBuilder();
				sb.append("/").append(a.getParentId()).append("/").append(a.getName());
				gr.setPath(sb.toString());
				return true;
			}).orElse(addPath(gr , a));
		a
		.getAttributes()
		.stream()
		.forEach(attr ->{
			Map<String , List<String>> attributeRepresentationMap = gr.getAttributes();
			if (attributeRepresentationMap !=null) {
				String attrName = attr.getName();
				List<String> attrList = attributeRepresentationMap.get(attrName);
				Optional
				.ofNullable(attrList)
				.map(l ->{
					return l.add(attr.getValue());
				})
				.orElse(addAttribute(attr  , attributeRepresentationMap));
			}else {
				Map<String , List<String>> representationMap = new HashMap<>();
				addAttribute(attr  , representationMap);
				gr.setAttributes(representationMap);
			}
		});
		return gr;
	}

	private Boolean addPath(GroupRepresentation gr, GroupEntity a) {
		gr.setPath("/" + a.getName());
		return true;
	}

	private Boolean addAttribute(GroupAttributeEntity attr, Map<String, List<String>> attributeRepresentationMap) {
		List<String> list = new ArrayList<String>();
		list.add(attr.getValue());
		attributeRepresentationMap.put(attr.getName(), list);
		return true;
	}

	@Override
	public GroupEntity doBackward(GroupRepresentation b) {
		GroupEntity ge = new GroupEntity();
		return null;
	}
}
