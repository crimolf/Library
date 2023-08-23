package it.fivenet.playground.library.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

