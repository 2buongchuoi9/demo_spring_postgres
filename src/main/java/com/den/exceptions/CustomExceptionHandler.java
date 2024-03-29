package com.den.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler(NotFoundError.class)
  public ResponseEntity<?> handlerNotFoundException(NotFoundError ex, WebRequest req) {
    // Log err

    ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicateRecordException.class)
  public ResponseEntity<?> handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
    // Log err

    ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

  // Xử lý tất cả các exception chưa được khai báo
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handlerException(Exception ex, WebRequest req) {
    // Log err

    ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
