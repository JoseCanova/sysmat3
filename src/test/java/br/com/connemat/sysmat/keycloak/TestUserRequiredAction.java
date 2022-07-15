package br.com.connemat.sysmat.keycloak;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.keycloak.models.controller.services.RequiredActionProviderEntityService;
import org.keycloak.models.jpa.entities.RequiredActionProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestUserRequiredAction {

	@Autowired
	private RequiredActionProviderEntityService service;
	
	public TestUserRequiredAction() {
	}
	
	@Test
	void testGetConnematRequiredActions() {
		List<RequiredActionProviderEntity> actions = service.getAvailableRequiredActions("connemat");
		assertTrue(actions.size()>0);
	}
	
}
