package org.keycloak.models.utils;

import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import br.com.connemat.model.api.Client;

@Component
public class ClientRepresentationClientConverter extends Converter<ClientRepresentation,Client>{

	public ClientRepresentationClientConverter() {
	}

	@Override
	protected Client doForward(ClientRepresentation cr) {
		Client client = new Client();
		BeanUtils.copyProperties(cr, client);
		return client;
	}

	@Override
	protected ClientRepresentation doBackward(Client client) {
		return null;
	}

}
