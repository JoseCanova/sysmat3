package br.com.connemat;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;

public interface RequiredActionService {

	ResponseEntity<?> requiredActionsEmail(@NotEmpty String userId, @NotEmpty List<String> requiredActions);
	
}