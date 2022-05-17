package br.com.connemat.service.impl;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.connemat.RequiredActionService;
import br.com.connemat.rest.client.AdminRestClient;


@Service
@Qualifier(value="requiredActionService")
@Validated
public class RequiredActionServiceImpl implements RequiredActionService{

	@Autowired
	private AdminRestClient adminRestClient;
	
	public RequiredActionServiceImpl() {
	}

	@Override
	public ResponseEntity<?> requiredActionsEmail(@NotEmpty String userId, @NotEmpty List<String> requiredActions) {
		return adminRestClient.requiredActionsEmail(userId , requiredActions);
	}

}
