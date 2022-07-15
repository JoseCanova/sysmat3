package br.com.connemat.sysmat.keycloak;

import java.util.List;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.keycloak.models.utils.ClientRepresentationClientConverter;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.model.api.Client;
import br.com.connemat.model.api.validation.ClientUpdateValidation;
import br.com.connemat.rest.client.AdminRestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestClientRepresentationConverter {

	@Autowired
	private ClientRepresentationClientConverter converter; 
	
	@Autowired
	private AdminRestClient restClient;
	
	@Autowired
	private Validator validator;
	
	public TestClientRepresentationConverter() {
	}
	
	@Test
	void testConvertClientRepresentations() {
		List<ClientRepresentation> clientList = restClient.getClientsViewable();
		clientList
		.stream()
		.forEach(c ->{
			Client client = converter.convert(c);
			assertValid(client);
		});
	}

	private void assertValid(Client client) {
		Set<?> violations = validator.validate(client, ClientUpdateValidation.class , Default.class);
		assertTrue(violations.size() == 0);
	}

}
