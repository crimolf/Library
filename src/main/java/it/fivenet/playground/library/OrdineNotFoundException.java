package it.fivenet.playground.library;

public class OrdineNotFoundException extends RuntimeException {
    public OrdineNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

