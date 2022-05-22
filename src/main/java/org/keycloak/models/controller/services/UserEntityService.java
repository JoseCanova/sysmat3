package org.keycloak.models.controller.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.models.repository.UserEntityRepository;
import org.keycloak.models.utils.UserRepresentationConverter;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.UserBaseService;
import br.com.connemat.model.api.PasswordDefinition;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserPasswordDefinition;
import br.com.connemat.model.api.validation.UserUpdateValidationGroup;
import br.com.connemat.rest.client.AdminRestClient;
import br.com.connemat.rest.client.model.IdRepresentation;

@Service
@Validated
@Primary
@Qualifier(value = "userEntityService")
@Profile(value = "keycloak")
public class UserEntityService implements UserBaseService {

	@Autowired
	private UserEntityRepository repository;
	
	@Autowired
	private AdminRestClient restClient;
	
	@Autowired
	private UserRepresentationConverter converter;
	
	public UserEntityService() {
	}
	
	@Transactional("keycloak-tm")
	public Optional<UserEntity> getByUserAndRealmId(@NotEmpty String user,
													@NotEmpty  String realmId){ 
			
		            Optional<UserEntity> userEntity = repository.findById(user);
		            if(!userEntity.isPresent())
		            	userEntity = repository.findByUsernameAndRealmId(user, realmId);
					if (!userEntity.isPresent())
						userEntity = repository.findByEmailAndRealmId(user, realmId);
					return userEntity;
	}

	@Transactional("keycloak-tm")
	public Optional<UserEntity> findByEmailAndRealmId(@NotEmpty String email, @NotEmpty String realmId) {
		return repository.findByEmailAndRealmId( email,  realmId);
	}
	
	@Transactional("keycloak-tm")
	public Optional<UserEntity> findByUsernameAndRealmId(@NotEmpty String username, @NotEmpty String realmId) {
		return repository.findByUsernameAndRealmId(username , realmId);
	}

	@Transactional("keycloak-tm")
	public Optional<UserEntity> findById(@NotEmpty String userId) {
		return repository.findById(userId);
	}

	@Transactional("keycloak-tm")
	public Optional<IdRepresentation> findByUsernameOrEmailAndRealmId(@NotEmpty String id , @NotEmpty  String realmId) {
		return repository
					.findByUsernameOrEmailAndRealmId(id , realmId)
					.map(ur -> new IdRepresentation(ur.getId()));
	}

	public ResponseEntity<?> addRealmUser(@Valid User user) {
		UserRepresentation ur = converter.convert(user);
		return restClient.addUser(ur);
	}
	
	@Validated(value = {UserUpdateValidationGroup.class , Default.class})
	public ResponseEntity<?> updateUser(@Valid User user) {
		UserRepresentation ur = converter.convert(user);
		return restClient.updateUser(ur);
	}

	@Validated(value = {UserUpdateValidationGroup.class , Default.class})
	@Override
	public ResponseEntity<?> addUserPassword(@Valid User user, @Valid PasswordDefinition pwd) {
		return restClient.resetPassword(user , pwd);
	}
	
	@Validated(value = {UserUpdateValidationGroup.class , Default.class})
	@Override
	public ResponseEntity<?> deleteUser(@Valid User user) {
		UserRepresentation ur = converter.convert(user);
		return  restClient.inactivateUser(ur);//restClient.deleteUser(user);
	}

	@Override
	public User getUser(@NotEmpty String userId) {
		ResponseEntity<UserRepresentation> rur =  restClient.getUser(userId);
		return Optional
		.ofNullable(rur.getBody())
		.map(ur ->{
			return converter.doBackward(ur);
		}).orElseThrow(RuntimeException::new);
	}

	@Transactional("keycloak-tm")
	public List<UserEntity> findAll() {
		return repository.findAll();
	}

	public <S extends UserEntity> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public List<UserEntity> findAllByRealmId(String realmId) {
		return repository.findAllByRealmId(realmId);
	}

	@Override
	public List<User> search(MultiValueMap<String,String> params) {
		return restClient.search(params);
	}

	@Override
	public ResponseEntity<?> addUserPassword(UserPasswordDefinition upd) {
		return addUserPassword(upd.getUser(), upd.getPassword());
	}

	@Validated(value= {UserUpdateValidationGroup.class , Default.class})
	@Override
	public ResponseEntity<?> updateUser(@NotEmpty String userId, @Valid User user) {
		if(!user.getId().equals(userId)) {
			throw new ConstraintViolationException(new HashSet<>());
		}
		return updateUser(user);
	}

}