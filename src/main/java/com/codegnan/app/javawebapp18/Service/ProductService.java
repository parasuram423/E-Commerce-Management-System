 package com.codegnan.app.javawebapp18.Service;

import java.util.List;

import com.codegnan.app.javawebapp18.dto.ProductDto;

public interface ProductService {

    boolean addProduct(ProductDto productDto);

    ProductDto searchProduct(int productId);

    ProductDto searchProduct(String productName);

    List<ProductDto> getAllProducts();

    boolean renameProduct(int productId, String updatedName);

    boolean removeProduct(int productId);
}