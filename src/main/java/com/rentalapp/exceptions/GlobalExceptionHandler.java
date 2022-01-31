package com.rentalapp.exceptions;

import com.rentalapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * GlobalExceptionHandler class to handle all the possible exceptions that may occur
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Method not allowed");
        String path = request.getContextPath();

        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);

    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Media type not supported");
        String path = request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Path variable is missing");
        String path = request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Request Parameter is missing");
        String path = request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Data type mismatch");
        String path = request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value=PropertyNotFoundException.class)
    public ResponseEntity<Object> handlePropertyNotFound(PropertyNotFoundException ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Property not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value=CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFound(CategoryNotFoundException ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "category not found");

        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "other exception" +ex.getMessage());
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }


}
