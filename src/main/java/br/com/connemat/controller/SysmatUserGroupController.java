package br.com.connemat.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.SysmatBaseGroupService;
import br.com.connemat.model.api.Group;

@RestController
@RequestMapping(path = "/sysmat-group" , 
				produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@Profile(value="keycloal")
public class SysmatUserGroupController {

	@Autowired
	@Qualifier("sysmatBaseGroupService")
	private SysmatBaseGroupService sysmatBaseGroupService;
	
	public SysmatUserGroupController() {
	}

	@GetMapping
	public ResponseEntity<List<Group>> getSysmatGroups() {
		return ResponseEntity.ok(sysmatBaseGroupService.getSysmatGroups());
	}

	@GetMapping(path="/user")
	public ResponseEntity<List<Group>> getSysmatUserGroups(@NotNull @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		return ResponseEntity.ok(sysmatBaseGroupService.getSysmatUserGroups(authentication));
	}

}
