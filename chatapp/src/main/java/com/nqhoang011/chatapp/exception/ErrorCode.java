package com.nqhoang011.chatapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    UNHANDLED_EXCEPTION(9999, "Unhandled exception"),
    INVALID_KEY(9998, "Invalid message key"),
    INVALID_USERNAME(1002, "Username must be at least 3 characters"),
    INVALID_PASSWORD(1003, "Password must be at least 8 characters"),
    USER_NOT_EXISTED(1004, "User not existed"),
    ;
    private int code;
    private String message;
}
