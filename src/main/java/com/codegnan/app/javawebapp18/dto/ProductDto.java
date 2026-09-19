package com.codegnan.app.javawebapp18.dto;

import java.time.LocalDateTime;

public record ProductDto(int id, String name, String brand, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {

}