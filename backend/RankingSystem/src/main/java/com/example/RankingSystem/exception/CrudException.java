package com.example.RankingSystem.exception;

public class CrudException extends RuntimeException {
    public CrudException(String errorMessage) {
        super(errorMessage);
    }
}