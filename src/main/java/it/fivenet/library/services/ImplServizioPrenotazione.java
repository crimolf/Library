package it.fivenet.library.services;

import it.fivenet.library.domain.Prenotazione;
import it.fivenet.library.repositories.RepositoryPrenotazione;
import org.springframework.stereotype.Service;

@Service
public class ImplServizioPrenotazione implements ServizioPrenotazione{
    private final RepositoryPrenotazione repositoryPrenotazione;

    public ImplServizioPrenotazione(RepositoryPrenotazione repositoryPrenotazione) {
        this.repositoryPrenotazione = repositoryPrenotazione;
    }

    @Override
    public Iterable<Prenotazione> findAll() {
        return repositoryPrenotazione.findAll();
    }

}
