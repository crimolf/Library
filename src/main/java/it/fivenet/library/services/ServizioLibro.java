package it.fivenet.library.services;

import it.fivenet.library.domain.Libro;

public interface ServizioLibro {
    Iterable<Libro> findAll();

}
