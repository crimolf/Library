package com.example.library_v2;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}

