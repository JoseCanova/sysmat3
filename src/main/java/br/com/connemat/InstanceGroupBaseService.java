package br.com.connemat;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.Authentication;

import br.com.connemat.model.api.Group;

public interface InstanceGroupBaseService {

	public static final String DEFAULT_REALM_ID = "connemat";
	
	public static final String INSTANCE =   "instance";

	List<Group> getInstances();

	List<Group> getInstanceGroups(@NotEmpty String instanceGroupId);

	List<Group> getUserInstances(@NotNull Authentication authentication);

	List<Group> getUserInstanceSubGroups(@NotNull Authentication authentication , @NotEmpty  String instanceGroupId);

}
