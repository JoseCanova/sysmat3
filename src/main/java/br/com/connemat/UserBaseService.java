package br.com.connemat;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.keycloak.models.jpa.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import br.com.connemat.model.api.PasswordDefinition;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserPasswordDefinition;
import br.com.connemat.rest.client.model.IdRepresentation;

public interface UserBaseService {

	ResponseEntity<?> addRealmUser(@Valid User user);
	
	default User addUser(@Valid User user) {
		return null;
	};
	
	ResponseEntity<?> updateUser(@Valid User user);
	
	ResponseEntity<?> deleteUser(@Valid User user);
	
	ResponseEntity<?> addUserPassword(@Valid User user, @Valid PasswordDefinition pwd);
	
	@Nullable User getUser(@NotEmpty String userId);
	
	List<User> search(MultiValueMap<String,String> params);

	ResponseEntity<?> addUserPassword(UserPasswordDefinition upd);

	ResponseEntity<?> updateUser(@NotEmpty  String userId, @Valid  User user);

	Optional<UserEntity> getByUserAndRealmId(@NotEmpty String user,
			@NotEmpty  String realmId);

	Optional<IdRepresentation> findByUsernameOrEmailAndRealmId(@NotEmpty String id, @NotEmpty String realmId);

	Optional<UserEntity> findByEmailAndRealmId(@NotEmpty String email, @NotEmpty String realmId);

	Optional<UserEntity> findByUsernameAndRealmId(@NotEmpty String username, @NotEmpty String realmId);

	Optional<UserEntity> findById(@NotEmpty String userId);
	
}
