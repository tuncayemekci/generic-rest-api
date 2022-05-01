package com.tuncayemekci.genericrestapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleApiRequestException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
