package com.Mahesh.microservices.restfulwebservices.exception;

import com.Mahesh.microservices.restfulwebservices.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandles extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
