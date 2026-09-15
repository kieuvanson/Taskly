package com.taskly.backend.exception;

 public enum  ErrorCode {
    USERNAME_ALREADY_EXISTS(1001, "Username already exists"),
    AGE_MUST_BE_AT_LEAST_18(1002, "Age must be at least 18"),
    VALIDATION_ERROR(1003, "Validation failed"),
    IsValidPassword(1004, "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit"),
    INVALID_CREDENTIALS(1005, "Invalid username or password");
    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private  int code;
    private  String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
