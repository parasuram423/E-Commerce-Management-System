 package com.codegnan.app.javawebapp18.Service;

import java.util.List;

import com.codegnan.app.javawebapp18.dao.AddressDao;
import com.codegnan.app.javawebapp18.dao.AddressDaoImpl;
import com.codegnan.app.javawebapp18.dto.AddressDto;

public class AddressServiceImpl implements AddressService {
	private static final AddressDao ADDRESS_DAO = new AddressDaoImpl();
	
	@Override
	public boolean addAddress(AddressDto addressDto) {
		return ADDRESS_DAO.save(addressDto);
	}
	
	@Override
	public List<AddressDto> getAddresses(int userId) {
		return ADDRESS_DAO.findByUserId(userId);
	}
}