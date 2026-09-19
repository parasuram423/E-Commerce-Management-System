package com.codegnan.app.javawebapp18.Service;

import com.codegnan.app.javawebapp18.dto.CredentialDto;
import com.codegnan.app.javawebapp18.dto.UserDto;

public interface UserService {
	boolean register(UserDto userDto, CredentialDto credentialDto);
	
	CredentialDto login(String username, String loginPassword);
	
	String hashPassword(String password);
}