package com.nqhoang011.chatapp.controller;

import com.nimbusds.jose.JOSEException;
import com.nqhoang011.chatapp.dto.request.ApiResponse;
import com.nqhoang011.chatapp.dto.request.AuthenticationRequest;
import com.nqhoang011.chatapp.dto.request.IntrospectRequest;
import com.nqhoang011.chatapp.dto.response.AuthenticationResponse;
import com.nqhoang011.chatapp.dto.response.IntrospectResponse;
import com.nqhoang011.chatapp.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        IntrospectResponse result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .code(200)
                .result(result)
                .build();
    }
}
