package com.example.library_v2;

public class OrdineNotFoundException extends RuntimeException {
    public OrdineNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

