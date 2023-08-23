package it.fivenet.playground.library.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

