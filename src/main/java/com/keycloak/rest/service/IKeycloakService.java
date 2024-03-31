package com.keycloak.rest.service;import java.util.List;

import org.keycloak.representations.idm.UserRepresentation;

import com.keycloak.rest.dto.UserDTO;


public interface IKeycloakService {

	List<UserRepresentation> findAllUsers();
	List<UserRepresentation> searchUserByUsername(String username);
	String createUser(UserDTO userDto);
	void deleteUser(String userId);
	void updateUser(String userId, UserDTO userDTO);
}
