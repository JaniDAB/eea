package com.janith.eea.Service;

public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}

