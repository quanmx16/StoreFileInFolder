package com.quanmx.uploadandstoretodirectory.exception;

import com.quanmx.uploadandstoretodirectory.viewmodel.ErrorVm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorVm> handleNotFoundException(NotFoundException notFoundException, WebRequest webRequest) {
        String message = notFoundException.getMessage();
        ErrorVm errorVm = new ErrorVm(HttpStatus.NOT_FOUND.toString(), "NotFound", message);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorVm);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorVm> handleIOException(IOException exception, WebRequest webRequest) {
        String message = exception.getMessage();
        ErrorVm errorVm = new ErrorVm(HttpStatus.BAD_REQUEST.toString(), "BadRequest", message);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorVm);
    }
}
