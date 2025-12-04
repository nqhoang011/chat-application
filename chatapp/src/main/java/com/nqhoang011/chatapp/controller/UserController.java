package com.nqhoang011.chatapp.controller;

import com.nqhoang011.chatapp.dto.request.ApiResponse;
import com.nqhoang011.chatapp.dto.request.UserCreateRequest;
import com.nqhoang011.chatapp.dto.request.UserUpdateRequest;
import com.nqhoang011.chatapp.dto.response.UserResponse;
import com.nqhoang011.chatapp.entity.User;
import com.nqhoang011.chatapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<User> response = new ApiResponse<>();

        response.setResult(userService.createUser(request));
        return response;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") UUID userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable UUID userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return "User has been Deleted";
    }
}
