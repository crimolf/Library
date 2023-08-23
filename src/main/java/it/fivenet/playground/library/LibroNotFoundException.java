package it.fivenet.playground.library;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

