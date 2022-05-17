package br.com.connemat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

import br.com.connemat.UserBaseService;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserPasswordDefinition;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/users"  , 
						produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserBaseService userEntityService;
	
	public UserController() {
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name="id"  , required=true)String userId){
		return ResponseEntity.ok(userEntityService.getUser(userId));
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return userEntityService.addRealmUser(user);
	}
	
	//TODO: validar id path com id usuario
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(name="id" , required=true ) String userId ,  @RequestBody User user) {
		return userEntityService.updateUser(userId , user);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestBody User user) {
		return userEntityService.deleteUser(user);
	}

	@PutMapping(path = "/reset-password")
	public ResponseEntity<?> addUserPassword( @RequestBody UserPasswordDefinition upd) {
		return userEntityService.addUserPassword(upd);
	}
	
	@GetMapping(path="/search")
	public ResponseEntity<List<User>> search (
	  @RequestParam(name="briefRepresentation",  required=false) Boolean briefRepresentation ,
	  @RequestParam(name="email",  required=false) String email , 
	  @RequestParam(name="emailVerified" , required=false) Boolean emailVerified,
	  @RequestParam(name="enabled" , required=false) Boolean enable, 
	  @RequestParam(name="exact" , required=false) Boolean exact,
	  @RequestParam(name="first" , required=false) Integer first, 
	  @RequestParam(name="firstName" , required=false) String firstName, 
	  @RequestParam(name="lastName" , required=false) String lastName, 
	  @RequestParam(name="max" , required=false) Integer max,  
	  @RequestParam(name="search" , required=false) String search,   
	  @RequestParam(name="username" , required=false) String username) 
	{
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("briefRepresentation" , "true");
//		Optional.ofNullable(briefRepresentation).ifPresent(p -> params.add("briefRepresentation", briefRepresentation.toString()));
		Optional.ofNullable(email).ifPresent(p -> params.add("email", email));
		Optional.ofNullable(emailVerified).ifPresent(p -> params.add("emailVerified", emailVerified.toString()));
		Optional.ofNullable(enable).ifPresent(p -> params.add("enable", enable.toString()));
		Optional.ofNullable(exact).ifPresent(p -> params.add("exact", exact.toString()));
		Optional.ofNullable(first).ifPresent(p -> params.add("first", first.toString()));
		Optional.ofNullable(firstName).ifPresent(p -> params.add("firstName", firstName));
		Optional.ofNullable(lastName).ifPresent(p -> params.add("lastName",lastName));
		Optional.ofNullable(max).ifPresent(p -> params.add("max", max.toString()));
		Optional.ofNullable(search).ifPresent(p -> params.add("search", search));
		Optional.ofNullable(username).ifPresent(p -> params.add("username", username));
		return ResponseEntity.ok(userEntityService.search(params));
	}
}
