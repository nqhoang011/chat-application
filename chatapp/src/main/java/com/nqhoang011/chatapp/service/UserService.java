package com.nqhoang011.chatapp.service;

import com.nqhoang011.chatapp.dto.request.UserCreateRequest;
import com.nqhoang011.chatapp.dto.request.UserUpdateRequest;
import com.nqhoang011.chatapp.dto.response.UserResponse;
import com.nqhoang011.chatapp.entity.User;
import com.nqhoang011.chatapp.exception.AppException;
import com.nqhoang011.chatapp.exception.ErrorCode;
import com.nqhoang011.chatapp.mapper.UserMapper;
import com.nqhoang011.chatapp.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    public User createUser(UserCreateRequest request) {

        if (userRepository.existsByUsername(request.getUsername())
                || userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(UUID userId) {
        return userMapper.toUserResponse(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(UUID userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        user.setUpdatedAt(LocalDateTime.now());
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
