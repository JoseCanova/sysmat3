package br.com.connemat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.keycloak.models.utils.ClientRepresentationClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.com.connemat.ClientBaseService;
import br.com.connemat.model.api.Client;
import br.com.connemat.rest.client.AdminRestClient;

@Service
@Qualifier(value="clientBaseService")
@Primary
public class ClientBaseServiceImpl implements ClientBaseService {

	@Autowired
	private ClientRepresentationClientConverter converter; 
	
	@Autowired
	private AdminRestClient restClient;
	
	
	public ClientBaseServiceImpl() {
	}

	@Override
	public List<Client> getClients() {
		return restClient.getClientsViewable().stream().map(c -> converter.convert(c)).collect(Collectors.toList());
	}

}