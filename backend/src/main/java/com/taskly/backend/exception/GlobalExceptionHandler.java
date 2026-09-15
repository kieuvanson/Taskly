package com.taskly.backend.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.taskly.backend.dto.request.APIrespone;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
  ResponseEntity<APIrespone> handlingRuntimeException(RuntimeException e) {
    APIrespone response = new APIrespone();
   response.setCode(9999);
   response.setMessage(e.getMessage());

    return ResponseEntity.badRequest().body(response);
    }

 @ExceptionHandler(AppException.class)
  ResponseEntity<APIrespone> handlingAppException(AppException e) {
    ErrorCode errorCode = e.getErrorCode();
    APIrespone response = new APIrespone();

   response.setCode(errorCode.getCode());
   response.setMessage(errorCode.getMessage());

    return ResponseEntity.badRequest().body(response);
    }

@ExceptionHandler(MethodArgumentNotValidException.class)
ResponseEntity<APIrespone<List<String>>> handlingValidException(
        MethodArgumentNotValidException e) {

    List<String> messages = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fieldError ->
                    fieldError.getField() + ": " + fieldError.getDefaultMessage())
            .toList();

    APIrespone<List<String>> response = new APIrespone<>();
    response.setCode(ErrorCode.VALIDATION_ERROR.getCode());
    response.setMessage("Validation failed");
    response.setData(messages);

    return ResponseEntity.badRequest().body(response);
}


}

