 package com.codegnan.app.javawebapp18.dao;

import java.util.List;

import com.codegnan.app.javawebapp18.dto.ProductDto;

public interface ProductDao {

    boolean save(ProductDto productDto);

    ProductDto findById(int productId);

    ProductDto findByName(String productName);

    List<ProductDto> findAll();

    boolean updateName(int productId, String updatedName);

    boolean delete(int productId);
}