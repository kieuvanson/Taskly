package com.taskly.backend.exception;

 public enum  ErrorCode {
    USERNAME_ALREADY_EXISTS(1001, "Username already exists");


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
