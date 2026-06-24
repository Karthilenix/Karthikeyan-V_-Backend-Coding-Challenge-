package com.hexaware.player.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String msg) {
        super(msg);
    }
}