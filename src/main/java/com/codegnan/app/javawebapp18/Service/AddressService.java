 package com.codegnan.app.javawebapp18.Service;

import java.util.List;

import com.codegnan.app.javawebapp18.dto.AddressDto;

public interface AddressService {
	boolean addAddress(AddressDto addressDto);
	
	List<AddressDto> getAddresses(int userId);
}