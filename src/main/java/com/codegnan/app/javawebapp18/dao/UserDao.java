package com.codegnan.app.javawebapp18.dao;

import com.codegnan.app.javawebapp18.dto.CredentialDto;
import com.codegnan.app.javawebapp18.dto.UserDto;

public interface UserDao {
	boolean save(UserDto userDto, CredentialDto credentialDto);
	
	CredentialDto findByUsername(String username);
}