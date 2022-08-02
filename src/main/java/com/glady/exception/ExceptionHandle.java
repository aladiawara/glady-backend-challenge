package com.glady.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionModel exceptionModel= new ExceptionModel(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFound.class)
    public final ResponseEntity<Object> handleAllExceptions(NotFound ex, WebRequest request){
        ExceptionModel exceptionModel= new ExceptionModel(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(exceptionModel, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequest.class)
    public final ResponseEntity<Object> handleAllExceptions(BadRequest ex, WebRequest request){
        ExceptionModel exceptionModel= new ExceptionModel(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }
}
