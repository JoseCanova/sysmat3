package br.com.connemat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.keycloak.models.utils.RoleRepresentationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.RoleBaseService;
import br.com.connemat.model.api.Role;
import br.com.connemat.rest.client.AdminRestClient;

@Validated
@Service
@Qualifier(value="roleBaseService")
@Primary
public class RoleBaseServiceImpl implements RoleBaseService {

	@Autowired
	private AdminRestClient restClient;
	
	@Autowired
	private RoleRepresentationConverter converter;
	
	public RoleBaseServiceImpl() {
	}

	@Override
	public List<Role> getRoles(@NotNull String clientId) {
		return restClient
				.getClientRoles(clientId)
				.stream()
				.map(rr -> converter.convert(rr))
				.collect(Collectors.toList());
	}

	@Override
	public Role getRoleByName(@NotNull String clientId, @NotEmpty String roleName) {
		return restClient
				.getClientRoleByName(clientId , roleName)
				.map(rr -> converter.convert(rr))
				.orElse(null);
	}
	
	@Override
	public ResponseEntity<?> createRole(@NotNull String clientId, @NotNull Role role) {
		return restClient.createRole(clientId , converter.doBackward(role));
	}

	@Override
	public ResponseEntity<?> deleteRole(@NotNull String clientId,@NotNull Role role) {
		return null;
	}

}
