package com.nqhoang011.chatapp.controller;

import com.nqhoang011.chatapp.dto.request.ApiResponse;
import com.nqhoang011.chatapp.dto.request.AuthenticationRequest;
import com.nqhoang011.chatapp.dto.response.AuthenticationResponse;
import com.nqhoang011.chatapp.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        Boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .result(AuthenticationResponse
                        .builder()
                        .isAuthenticated(result)
                        .build())
                .build();
    }
}
