package it.fivenet.library.services;

import it.fivenet.library.domain.Prenotazione;

public interface ServizioPrenotazione {
    Iterable<Prenotazione> findAll();

}
