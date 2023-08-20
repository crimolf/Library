package it.fivenet.library.services;

import it.fivenet.library.domain.Autore;
import it.fivenet.library.domain.Libro;

public interface ServizioAutore {
    Iterable<Autore> findAll();

}
