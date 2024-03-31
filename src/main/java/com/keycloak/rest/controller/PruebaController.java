package com.keycloak.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

	@GetMapping("/hola")
	@PreAuthorize("hasRole('admin_client_role')")
	public String diHola() {
		return "Hola";
	}
	
	@GetMapping("/holauser")
	@PreAuthorize("hasRole('user_client_role')")
	public String diHolaUser() {
		return "Hola user";
	}
}
