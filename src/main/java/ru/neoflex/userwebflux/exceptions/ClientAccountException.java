package ru.neoflex.userwebflux.exceptions;

public class ClientAccountException extends RuntimeException {
    public ClientAccountException(String message) {
        super(message);
    }
}
