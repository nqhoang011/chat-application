package com.nqhoang011.chatapp.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateRequest {
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
