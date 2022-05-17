package br.com.connemat.sysmat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.connemat.RequiredActionService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;



@SpringBootTest
public class TestRequiredActionService {
	
	public static final String DEFAULT_USER = "756d7814-db3f-472d-aca2-4d020c111d1a";

	public static final String UPDATE_PASSWORD = "UPDATE_PASSWORD";
	
	@Autowired
	@Qualifier("requiredActionService")
	private RequiredActionService requiredActionService;

	
	public TestRequiredActionService() {
	}

	@Test
	void testParameterValidation() {
		assertNotNull(requiredActionService);
		assertThrows (Exception.class , new Executable() {

			@Override
			public void execute() throws Throwable {
				requiredActionService.requiredActionsEmail(DEFAULT_USER, null);
			}} );
		List<String> requiredActions = new ArrayList<>();
		requiredActions.add(UPDATE_PASSWORD);
		ResponseEntity<?> response = requiredActionService.requiredActionsEmail(DEFAULT_USER, requiredActions);
		System.err.println(response.getStatusCode());
	}
}
