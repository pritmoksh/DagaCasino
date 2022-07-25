package com.dagacube.casino.exception;

import org.springframework.http.HttpStatus;

public class PlayerNotFoundException extends RuntimeException {

    private final String code;

    public PlayerNotFoundException(HttpStatus message, String player_not_found) {
        super(message.toString());
        this.code = message.toString();
    }

}

