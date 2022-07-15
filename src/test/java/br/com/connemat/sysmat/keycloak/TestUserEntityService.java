package br.com.connemat.sysmat.keycloak;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.keycloak.models.controller.services.UserEntityService;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.utils.UserEntityUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.connemat.controller.UserController;
import br.com.connemat.model.api.PasswordDefinition;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserAttribute;
import br.com.connemat.model.api.UserRequiredAction;
import br.com.connemat.model.api.validation.UserUpdateValidationGroup;
import br.com.connemat.service.config.UserRequiredActionService;


@SpringBootTest
public class TestUserEntityService {
	
	public static final String NAME = "user_name";
	
	public static final String EMAIL = "email@email.com";
	
	public static final String LAST_NAME = "user_last_name";

	public static final String ATTRIBUTE_NAME = "ATTRIBUTE_NAME";

	public static final String ATTRIBUTE_VALUE = "ATTRIBUTE_VALUE";
	
	public static final String REALM_ID = "connemat";

	@Autowired
	private UserEntityService userEntityService;
	
	@Autowired 
	private UserRequiredActionService actionServices;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private UserController controller;
	

	public TestUserEntityService() {
	}
	
	@Test
	void testAddDefaultUser() {
		User user = populateUser();
		ResponseEntity<?> response = userEntityService.addRealmUser(user);
		assertTrue(response.getStatusCodeValue() == 201);
	}
	
	@Test
	void testAddDeleteDefaultUser() {
		User user = populateUser();
		ResponseEntity<?> response = userEntityService.addRealmUser(user);
		assertTrue(response.getStatusCodeValue() == 201);
		Optional<UserEntity> ue = userEntityService.findByUsernameAndRealmId(user.getEmail(), REALM_ID);
		User theUser = ue.map(u -> {
			return new UserEntityUserConverter().doForward(u);
		}).orElseThrow(RuntimeException::new);
		ResponseEntity<?> re = userEntityService.deleteUser(theUser);
		assertTrue(re.getStatusCodeValue() == 204);
	}
	
	@Test
	void testAddDefaultUserPassword() {
		PasswordDefinition pwd = createPasswordDefinition();
		User user = populateUser();
		ResponseEntity<?> response = userEntityService.addRealmUser(user);
		assertTrue(response.getStatusCodeValue() == 201);
		Optional<UserEntity> ue = userEntityService.findByUsernameAndRealmId(user.getEmail(), REALM_ID);
		User theUser = ue.map(u -> {
			return new UserEntityUserConverter().doForward(u);
		}).orElseThrow(RuntimeException::new);
		ResponseEntity<?> re = userEntityService.addUserPassword(theUser,pwd);
		assertTrue(re.getStatusCodeValue() == 204);
	}

	private PasswordDefinition createPasswordDefinition() {
		PasswordDefinition pwd = new PasswordDefinition();
		pwd.setType("password");
		pwd.setTemporary(false);
		pwd.setValue("temp123");
		return pwd;
	}

	private User populateUser() {
		User user = new User();
		user.setFirstName(NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		user.setEnabled(true);
		user.setEmailVerified(false);
		List<UserAttribute> list = new ArrayList<>();
		UserAttribute at = new UserAttribute();
		at.setName(ATTRIBUTE_NAME);
		at.setValue(ATTRIBUTE_VALUE);
		list.add(at);
		user.setAttributes(list);
		List<String> actions = getRequiredActions();
		user.setRequiredActions(actions);
		return user;
	}

	private List<String> getRequiredActions() {
		List<UserRequiredAction> requiredActions = actionServices.getRequiredActions(REALM_ID);
		List<String> actions = new ArrayList<>();
		requiredActions
		.stream()
		.forEach(action ->{
			actions.add(action.getAlias());
		});
		return actions;
	}
	
	@Test
	void testGetUserById() {
		List<UserEntity> users = userEntityService.findAllByRealmId(REALM_ID);
		assertTrue(users.size()>0);
		users
		.stream()
		.filter (u -> validUser(u))
		.forEach(u ->{
			User theUser = userEntityService.getUser(u.getId());
			assertUserValid(theUser);
		});
	}

	private Boolean validUser(UserEntity u) {
		return notEmpty(u.getEmail()) && notEmpty(u.getFirstName()) && notEmpty(u.getLastName()) &&  notEmpty(u.getUsername()) && u.isEnabled();
	}

	private boolean notEmpty(String val) {
		return val !=null && val.trim().length() > 0;
	}

	private void assertUserValid(User theUser) {
		Set<?> violations = validator.validate(theUser , UserUpdateValidationGroup.class , Default.class);
		assertTrue(violations.size() ==0);
	}
	
	@Test
	void testUserSearch() {
		ResponseEntity<List<User>> userResponse =  controller.search(true, 
																	"jose.canova@connemat.com.br", 
																	null, 
																	null, 
																	null, 
																	null, 
																	null, 
																	null, 
																	null, 
																	null, 
																	"jcanova");
		assertTrue(userResponse.getStatusCode().value() == 200);
		assertTrue(userResponse.getBody().size() == 1); 
	}

}
