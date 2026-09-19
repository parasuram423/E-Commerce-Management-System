 package com.codegnan.app.javawebapp18.Service;

import java.util.List;

import com.codegnan.app.javawebapp18.dao.ProductDao;
import com.codegnan.app.javawebapp18.dao.ProductDaoImpl;
import com.codegnan.app.javawebapp18.dto.ProductDto;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }

    @Override
    public boolean addProduct(ProductDto productDto) {

        System.out.println("========== SERVICE ==========");
        System.out.println("Product Name: " + productDto.name());
        System.out.println("Brand: " + productDto.brand());
        System.out.println("Description: " + productDto.description());
        System.out.println("Status: " + productDto.status());
        System.out.println("Created At: " + productDto.createdAt());
        System.out.println("Updated At: " + productDto.updatedAt());
        System.out.println("=============================");

        return productDao.save(productDto);
    }

    @Override
    public ProductDto searchProduct(int productId) {
        return productDao.findById(productId);
    }

    @Override
    public ProductDto searchProduct(String productName) {
        return productDao.findByName(productName);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public boolean renameProduct(int productId, String updatedName) {
        return productDao.updateName(productId, updatedName);
    }

    @Override
    public boolean removeProduct(int productId) {
        return productDao.delete(productId);
    }
}