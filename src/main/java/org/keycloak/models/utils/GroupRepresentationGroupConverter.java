package org.keycloak.models.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.GroupAttribute;

@Component
public class GroupRepresentationGroupConverter extends Converter<GroupRepresentation , Group> {

	@Override
	public Group doForward(GroupRepresentation gr) {
		Group group = createDefaultRepresentation(gr);
		populateAttributes(group , gr);
		populateClientRoles(group  , gr);
		populateRealmRoles(group  , gr);
		populateChildGroups(group , gr);
		return group;
	}

	private void populateChildGroups(Group group, GroupRepresentation gr) {
		List<GroupRepresentation> grs = gr.getSubGroups() ;
		if(grs !=null)
			grs
			.forEach(sgr -> {
				Group subGroup = convert(sgr);
				group.getSubGroups().add(subGroup);
			});
	}

	private void populateRealmRoles(Group group, GroupRepresentation gr) {
			List<String> realmRoles = gr.getRealmRoles();
			if(realmRoles !=null)
				realmRoles
				.forEach(r ->{
					group.getRealmRoles().add(r);
				});
	}

	private void populateClientRoles(Group group, GroupRepresentation gr) {
		Map<String, List<String>> roles = gr.getClientRoles();
		if (roles !=null)
			roles
			.forEach((k,v) -> {
				List<String> roles1 = new ArrayList<>(v);
				group.getClientRoles().put(k, roles1);
			});
	}

	private void populateAttributes(Group group, GroupRepresentation gr) {
		Map<String , List<String>> atts = gr.getAttributes();
		if (atts != null)
			atts
			.keySet()
			.stream()
			.forEach(k -> {
				List<String> values = atts.get(k);
				String value = values.stream().reduce((x , i) -> x + ";" + i ).get();
				GroupAttribute ga = new GroupAttribute();
				ga.setName(k);
				ga.setValue(value);
				group.getAttributes().add(ga);
			});
	}

	private Group createDefaultRepresentation(GroupRepresentation gr) {
		Group group = new Group();
		group.setId(gr.getId());
		group.setName(gr.getName());
		group.setPath(gr.getPath());
		return group;
	}

	@Override
	public GroupRepresentation doBackward(Group group) {
		GroupRepresentation gr = new GroupRepresentation();
		gr.setId(group.getId());
		gr.setName(group.getName());
		gr.setPath(group.getPath());
		gr.setAttributes(getGroupAttributes(group));
		gr.setRealmRoles(getRealmRoles(group));
		gr.setClientRoles(getClientRoles(group));
		return gr;
	}

	private Map<String, List<String>> getClientRoles(Group group) {
		Map<String ,List<String>> clientRoles = new HashMap<>();
		group
			.getClientRoles()
			.forEach((k,v)  ->{
				List<String> roles = new ArrayList<>();
				v.stream().forEach(r1 -> roles.add(r1));
				clientRoles.put(k , roles);
			});
		return clientRoles;
	}

	private List<String> getRealmRoles(Group group) {
		List<String> theRoles = new ArrayList<>();
		group.getRealmRoles().forEach(r -> theRoles.add(r));
		return theRoles;
	}

	private Map<String, List<String>> getGroupAttributes(Group group) {
		Map<String , List<String>> atts = new HashMap<>();
		group
		.getAttributes()
		.stream()
		.forEach(a ->{
			List<String> valList = new ArrayList<>();
			valList.add(a.getValue());
			atts.put(a.getName(), valList);
		});
		return atts;
	}

}
