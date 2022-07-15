package br.com.connemat.sysmat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.model.api.UserRequiredAction;
import br.com.connemat.service.config.UserRequiredActionService;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestUserRequiredAction {

	@Autowired
	private UserRequiredActionService service;
	
	private static final String REALMID = "connemat";
	
	public TestUserRequiredAction() {
	}
	
	@Test
	void testUserRequiredActionServiceList() {
		List<UserRequiredAction> actions = service.getRequiredActions(REALMID);
		assertTrue(actions.size() > 0);
	}

}
