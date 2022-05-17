package br.com.connemat.service.config;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.keycloak.models.controller.services.RequiredActionProviderEntityService;
import org.keycloak.models.utils.UserRequiredActionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.api.UserRequiredAction;

@Service
@Validated
public class UserRequiredActionService {

	@Autowired 
	private RequiredActionProviderEntityService requiredActionService;
	
	@Autowired 
	private UserRequiredActionConverter converter;
	
	public UserRequiredActionService() {
	}
	
	public List<UserRequiredAction> getRequiredActions(@Valid @NotNull String realmId){
		return requiredActionService
				.getAvailableRequiredActions(realmId)
				.stream()
				.map(action ->{
					return converter.convert(action);
				}).collect(Collectors.toList());
	}

}
