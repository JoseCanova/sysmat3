package br.com.connemat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.GroupBaseService;
import br.com.connemat.model.api.Group;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/groups" , 
					produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

	@Autowired
	private GroupBaseService service;
	
	public GroupController() {
	}

	@GetMapping
	public ResponseEntity<List<Group>> getAllGroups(@RequestParam(name = "search" , required = false) String searchString){
		return Optional.ofNullable(searchString)
					.map(s -> ResponseEntity.ok(service.getGroups(s)))
					.orElse(ResponseEntity.ok(service.getAllGroups()));
	}
	
	@PostMapping
	public ResponseEntity<Group> addGroup(@RequestBody Group group){
		return ResponseEntity.ok(service.addGroup(group));
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Group> getGroup(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(service.getGroup(id));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") String id){
		service.deleteGroup(id);
		return ResponseEntity.ok().body(id);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name = "id") String id  , @RequestBody Group group){
		return ResponseEntity.ok().body(service.updateGroup(id  , group));
	}
	
	@PostMapping(path="/{id}/subgroup")
	public ResponseEntity<Group> addSubGroup(@PathVariable(name = "id") String id , @RequestBody Group group){
		return ResponseEntity.ok(service.addSubGroup(id ,  group));
	}
	
}
