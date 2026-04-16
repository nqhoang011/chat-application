package com.nqhoang011.chatapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    UUID id = UUID.randomUUID();
    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<String> roles;
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime updatedAt = null;
    LocalDateTime deletedAt = null;
}
