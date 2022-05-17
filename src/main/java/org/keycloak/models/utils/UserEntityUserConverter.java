package org.keycloak.models.utils;

import org.keycloak.models.jpa.entities.UserEntity;

import com.google.common.base.Converter;

import br.com.connemat.model.api.User;

public class UserEntityUserConverter extends Converter<UserEntity, User> {

	@Override
	public User doForward(UserEntity ue) {
		User u = new User();
		u.setId(ue.getId());
		u.setEmail(ue.getEmail());
		u.setFirstName(ue.getFirstName());
		u.setLastName(ue.getLastName());
		u.setEnabled(ue.isEnabled());
		u.setEmailVerified(ue.isEmailVerified());
		return u;
	}

	@Override
	public UserEntity doBackward(User b) {
		return null;
	}

}
