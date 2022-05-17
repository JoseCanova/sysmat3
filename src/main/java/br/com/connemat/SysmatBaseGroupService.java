package br.com.connemat;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.Authentication;

import br.com.connemat.model.api.Group;

public interface SysmatBaseGroupService {

	public static final String DEFAULT_REALM_ID = "connemat";

	public static final String SYSMAT_USER_GROUP =   "sysmat_user_group";

	List<Group> getSysmatGroups();

	List<Group> getSysmatUserGroups(@NotNull Authentication authentication);

}
