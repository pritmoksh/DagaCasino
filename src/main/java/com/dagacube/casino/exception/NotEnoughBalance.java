package com.dagacube.casino.exception;

import org.springframework.http.HttpStatus;

public class NotEnoughBalance extends RuntimeException {

    private final String code;

    public NotEnoughBalance(HttpStatus message, String player_not_found) {
        super(message.toString());
        this.code = message.toString();
    }
}
    

