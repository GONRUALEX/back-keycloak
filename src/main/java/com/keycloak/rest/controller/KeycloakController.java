package com.keycloak.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keycloak.rest.dto.UserDTO;
import com.keycloak.rest.service.IKeycloakService;

@RestController
@RequestMapping("/keykloak/user")
@PreAuthorize("hasRole('admin_client_role')")
public class KeycloakController {
	
	@Autowired
	private IKeycloakService keycloakService;
	
	
	@GetMapping("/search")
	public ResponseEntity<?> findAllUser(){
		return ResponseEntity.ok(keycloakService.findAllUsers());
	}
	
	@GetMapping("/search/{username}")
	public ResponseEntity<?> findAllUser(@PathVariable String username){
		return ResponseEntity.ok(keycloakService.findAllUsers());
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDto) throws URISyntaxException{
		String response = keycloakService.createUser(userDto);
		return ResponseEntity.created(new URI("/keykloak/user/create")).body(response);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDTO userDto){
		keycloakService.updateUser(userId, userDto);
		return ResponseEntity.ok("User actualizado");
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
		keycloakService.deleteUser(userId);
		return ResponseEntity.noContent().build();
		
		
		
	}

}
