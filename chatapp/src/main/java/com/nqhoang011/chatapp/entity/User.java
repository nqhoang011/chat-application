package com.nqhoang011.chatapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Getter
@Setter
public class User {
    @Id
    private UUID id = UUID.randomUUID();
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = null;
}
