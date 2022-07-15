package br.com.connemat;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import br.com.connemat.model.api.Role;

public interface RoleBaseService {

	List<Role> getRoles(@NotNull String clientId);
	
	Role getRoleByName(@NotNull String clientId , @NotEmpty String roleName);
	
	ResponseEntity<?> createRole(@NotNull String clientId  , @NotNull Role role);
	
	ResponseEntity<?> deleteRole (@NotNull String clientId  , @NotNull Role role);
	
}
