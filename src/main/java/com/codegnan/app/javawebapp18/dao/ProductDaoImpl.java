 package com.codegnan.app.javawebapp18.dao;

import java.util.ArrayList;
import java.util.List;

import com.codegnan.app.javawebapp18.dto.ProductDto;
import com.codegnan.app.javawebapp18.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProductDaoImpl implements ProductDao {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ecommercePU");

    // =========================
    // SAVE PRODUCT
    // =========================
    @Override
    public boolean save(ProductDto productDto) {

        EntityManager entityManager = null;

        try {

            entityManager =
                    entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Product product = new Product();

            product.setName(productDto.name());
            product.setBrand(productDto.brand());
            product.setDescription(productDto.description());
            product.setStatus(productDto.status());
            product.setCreatedAt(productDto.createdAt());
            product.setUpdatedAt(productDto.updatedAt());

            entityManager.persist(product);

            entityManager.getTransaction().commit();

            System.out.println("=================================");
            System.out.println("PRODUCT INSERT SUCCESS");
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("=================================");

            return true;

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("PRODUCT SAVE ERROR");
            System.out.println("ERROR MESSAGE: " + e.getMessage());
            System.out.println("=================================");

            if (entityManager != null
                    && entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            // Actual error ni hide cheyyakunda servlet ki pampistundi
            throw new RuntimeException(
                    "PRODUCT SAVE FAILED: " + e.getMessage(), e
            );

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    // =========================
    // FIND PRODUCT BY ID
    // =========================
    @Override
    public ProductDto findById(int productId) {

        ProductDto productDto = null;

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {

            Product product =
                    entityManager.find(Product.class, productId);

            if (product != null) {

                productDto = new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getBrand(),
                        product.getDescription(),
                        product.getStatus(),
                        product.getCreatedAt(),
                        product.getUpdatedAt()
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productDto;
    }

    // =========================
    // FIND PRODUCT BY NAME
    // =========================
    @Override
    public ProductDto findByName(String productName) {

        ProductDto productDto = null;

        String jpql =
                "SELECT p FROM Product p WHERE p.name = :proName";

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {

            Query query = entityManager
                    .createQuery(jpql)
                    .setParameter("proName", productName);

            Product product =
                    (Product) query.getSingleResult();

            productDto = new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getBrand(),
                    product.getDescription(),
                    product.getStatus(),
                    product.getCreatedAt(),
                    product.getUpdatedAt()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productDto;
    }

    // =========================
    // FIND ALL PRODUCTS
    // =========================
    @Override
    public List<ProductDto> findAll() {

        List<ProductDto> productDtosList =
                new ArrayList<>();

        String jpql =
                "SELECT p FROM Product p";

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {

            Query query =
                    entityManager.createQuery(jpql);

            List<Product> productsList =
                    query.getResultList();

            for (Product product : productsList) {

                ProductDto productDto = new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getBrand(),
                        product.getDescription(),
                        product.getStatus(),
                        product.getCreatedAt(),
                        product.getUpdatedAt()
                );

                productDtosList.add(productDto);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productDtosList;
    }

    // =========================
    // UPDATE PRODUCT NAME
    // =========================
    @Override
    public boolean updateName(int productId,
                              String updatedName) {

        EntityManager entityManager = null;

        try {

            entityManager =
                    entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Product product =
                    entityManager.find(Product.class, productId);

            if (product != null) {

                product.setName(updatedName);

                entityManager.getTransaction().commit();

                return true;

            } else {

                entityManager.getTransaction().rollback();

                return false;
            }

        } catch (Exception e) {

            e.printStackTrace();

            if (entityManager != null
                    && entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            return false;

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    // =========================
    // DELETE PRODUCT
    // =========================
    @Override
    public boolean delete(int productId) {

        EntityManager entityManager = null;

        try {

            entityManager =
                    entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Product product =
                    entityManager.find(Product.class, productId);

            if (product != null) {

                entityManager.remove(product);

                entityManager.getTransaction().commit();

                return true;

            } else {

                entityManager.getTransaction().rollback();

                return false;
            }

        } catch (Exception e) {

            e.printStackTrace();

            if (entityManager != null
                    && entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            return false;

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}