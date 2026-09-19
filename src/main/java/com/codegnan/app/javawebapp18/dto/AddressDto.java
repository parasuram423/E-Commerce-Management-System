 package com.codegnan.app.javawebapp18.dto;

public record AddressDto(int addressId, String label, String line1, String line2, String line3, String city, String state, String pincode, UserDto userDto){
	
}