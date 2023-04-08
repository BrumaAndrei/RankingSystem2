package com.example.RankingSystem.handlers;

import com.example.RankingSystem.exception.ApiException;
import com.example.RankingSystem.exception.CrudException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleJobFailureException(RuntimeException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, 500, ZonedDateTime.now(ZoneId.of("Z")));
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {InterruptedException.class})
    public ResponseEntity<Object> handleInterruptedException(InterruptedException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, 500, ZonedDateTime.now(ZoneId.of("Z")));
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CrudException.class})
    public ResponseEntity<Object> handleCrudOperationException(CrudException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND, 500, ZonedDateTime.now(ZoneId.of("Z")));
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
