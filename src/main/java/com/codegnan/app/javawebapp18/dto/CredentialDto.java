 package com.codegnan.app.javawebapp18.dto;

public record CredentialDto(
        int credentialId,
        String username,
        String loginPassword,
        UserDto userDto
) {

}