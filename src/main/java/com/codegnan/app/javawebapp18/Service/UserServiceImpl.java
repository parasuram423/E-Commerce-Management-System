 package com.codegnan.app.javawebapp18.Service;

import com.codegnan.app.javawebapp18.dao.UserDao;
import com.codegnan.app.javawebapp18.dao.UserDaoImpl;
import com.codegnan.app.javawebapp18.dto.CredentialDto;
import com.codegnan.app.javawebapp18.dto.UserDto;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserServiceImpl implements UserService {

    UserDao employeeDao = new UserDaoImpl();

    @Override
    public boolean register(UserDto userDto, CredentialDto credentialDto) {
        return employeeDao.save(userDto, credentialDto);
    }

    @Override
    public CredentialDto login(String username, String loginPassword) {

        CredentialDto credentialDto = null;

        credentialDto = employeeDao.findByUsername(username);

        if (credentialDto != null) {

            char[] inputPassword = loginPassword.toCharArray();
            char[] hashedPassword = credentialDto.loginPassword().toCharArray();

            boolean isMatching = BCrypt.verifyer()
                    .verify(inputPassword, hashedPassword)
                    .verified;

            if (!isMatching) {
                return null;
            }
        }

        return credentialDto;
    }

    @Override
    public String hashPassword(String password) {

        String hashedPassword =
                BCrypt.withDefaults()
                        .hashToString(10, password.toCharArray());

        return hashedPassword;
    }
}