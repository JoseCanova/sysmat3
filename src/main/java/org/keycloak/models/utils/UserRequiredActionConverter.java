package org.keycloak.models.utils;

import org.keycloak.models.jpa.entities.RequiredActionProviderEntity;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.UserRequiredAction;

@Component
public class UserRequiredActionConverter extends Converter<RequiredActionProviderEntity , UserRequiredAction> {

	@Override
	public UserRequiredAction doForward(RequiredActionProviderEntity rae) {
		UserRequiredAction ura = new UserRequiredAction();
		ura.setId(rae.getId());
		ura.setName(rae.getName());
		ura.setAlias(rae.getAlias());
		ura.setPriority(rae.getPriority());
		ura.setEnabled(rae.isEnabled());
		ura.setDefaultAction(rae.isDefaultAction());
		return ura;
	}

	@Override
	public RequiredActionProviderEntity doBackward(UserRequiredAction ura) {
		RequiredActionProviderEntity rae = new RequiredActionProviderEntity();
		return rae;
	}

}
