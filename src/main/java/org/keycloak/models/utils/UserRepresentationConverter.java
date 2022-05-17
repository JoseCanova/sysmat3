package org.keycloak.models.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserAttribute;


@Component
public class UserRepresentationConverter extends Converter<User, UserRepresentation> {

	@Override
	public UserRepresentation doForward(User user) {
		UserRepresentation ur = new UserRepresentation();
		ur.setId(user.getId());
		ur.setUsername(user.getEmail());
		ur.setEmail(user.getEmail());
		ur.setFirstName(user.getFirstName());
		ur.setLastName(user.getLastName());
		ur.setEmailVerified(user.getEmailVerified());
		ur.setEnabled(user.getEnabled());
		ur.setAttributes(mountUserRepresentationAttribute(user));
		ur.setRequiredActions(user.getActions());
		return ur;
	}

	private Map<String, List<String>> mountUserRepresentationAttribute(User user) {
		Map<String  , List<String>> attributes  = new HashMap<>();
		Optional.ofNullable(user
			.getAttributes())
		.ifPresent(atts ->{
			atts
			.stream()
			.forEach(a ->{
				List<String> list = new ArrayList<>();
				list.add(a.getValue());
				attributes.put(a.getName(), list);
			});
			
		});
		return attributes;
	}

	@Override
	public User doBackward(UserRepresentation user) {
		User ur = new User();
		ur.setId(user.getId());
		ur.setEmail(user.getEmail());
		ur.setFirstName(user.getFirstName());
		ur.setLastName(user.getLastName());
		ur.setEmailVerified(user.isEmailVerified());
		ur.setEnabled(user.isEnabled());
		ur.setAttributes(mountUserAttributes(user));
		ur.setRequiredActions(user.getRequiredActions());
		return ur;
	}

	private List<UserAttribute> mountUserAttributes(UserRepresentation user) {
		List<UserAttribute> list = new ArrayList<>();
		Map<String , List<String>> attMap = user
				.getAttributes();
		if(attMap !=null)
			attMap
			.forEach((k , v) ->{
					UserAttribute uat = new UserAttribute();
					uat.setName(k);
					uat.setValue(v.get(0));
					list.add(uat);
		});
		return list;
	}

}
