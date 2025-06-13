package com.target.nextbus.exception;

public class MultipleMatchesException extends RuntimeException {
    public MultipleMatchesException(String message) {
        super(message);
    }
}
