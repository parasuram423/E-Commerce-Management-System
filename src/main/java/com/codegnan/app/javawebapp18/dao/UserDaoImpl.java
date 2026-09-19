 package com.codegnan.app.javawebapp18.dao;

import com.codegnan.app.javawebapp18.dto.CredentialDto;
import com.codegnan.app.javawebapp18.dto.UserDto;
import com.codegnan.app.javawebapp18.entity.Credential;
import com.codegnan.app.javawebapp18.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDaoImpl implements UserDao {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ecommercePU");

    // =========================
    // SIGN UP / SAVE USER
    // =========================
    @Override
    public boolean save(UserDto userDto, CredentialDto credentialDto) {

        boolean isSaved = false;

        EntityManager entityManager = null;

        try {

            entityManager =
                    entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            // Create User entity
            User user = new User();

            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());

            // Save user first
            entityManager.persist(user);

            // Create Credential entity
            Credential credential = new Credential();

            credential.setUsername(credentialDto.username());
            credential.setLoginPassword(credentialDto.loginPassword());

            // Connect credential with user
            credential.setUser(user);

            // Save credential
            entityManager.persist(credential);

            // Commit transaction
            entityManager.getTransaction().commit();

            isSaved = true;

            System.out.println("========== SIGNUP SUCCESS ==========");
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Username: " + credential.getUsername());
            System.out.println("====================================");

        } catch (RuntimeException runtimeException) {

            System.out.println("========== SIGNUP ERROR ==========");

            if (entityManager != null
                    && entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            runtimeException.printStackTrace();

            System.out.println("==================================");

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }

        return isSaved;
    }

    // =========================
    // FIND USER BY USERNAME
    // =========================
    @Override
    public CredentialDto findByUsername(String username) {

        CredentialDto credentialDto = null;

        EntityManager entityManager = null;

        try {

            entityManager =
                    entityManagerFactory.createEntityManager();

            String jpql =
                    "SELECT c FROM Credential c WHERE c.username = :username";

            Query query = entityManager
                    .createQuery(jpql)
                    .setParameter("username", username);

            Credential credential =
                    (Credential) query.getSingleResult();

            User user = credential.getUser();

            UserDto userDto = new UserDto(
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName()
            );

            credentialDto = new CredentialDto(
                    credential.getCredentialId(),
                    credential.getUsername(),
                    credential.getLoginPassword(),
                    userDto
            );

        } catch (RuntimeException runtimeException) {

            runtimeException.printStackTrace();

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }

        return credentialDto;
    }
}