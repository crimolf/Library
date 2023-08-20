package it.fivenet.library.services;

import it.fivenet.library.domain.Autore;
import it.fivenet.library.domain.Libro;
import it.fivenet.library.repositories.RepositoryAutore;
import it.fivenet.library.repositories.RepositoryLibro;
import org.springframework.stereotype.Service;

@Service
public class ImplServizioAutore implements ServizioAutore{
    private final RepositoryAutore repositoryAutore;

    public ImplServizioAutore(RepositoryAutore repositoryAutore) {
        this.repositoryAutore = repositoryAutore;
    }

    @Override
    public Iterable<Autore> findAll() {
        return repositoryAutore.findAll();
    }

}
