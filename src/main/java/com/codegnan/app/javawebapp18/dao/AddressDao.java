 package com.codegnan.app.javawebapp18.dao;

import java.util.List;

import com.codegnan.app.javawebapp18.dto.AddressDto;

public interface AddressDao {
	boolean save(AddressDto addressDto);
	
	List<AddressDto> findByUserId(int userId);
}