package it.fivenet.library.services;

import it.fivenet.library.domain.Libro;
import it.fivenet.library.repositories.RepositoryLibro;
import org.springframework.stereotype.Service;

@Service
public class ImplServizioLibro implements ServizioLibro{
    private final RepositoryLibro repositoryLibro;

    public ImplServizioLibro(RepositoryLibro repositoryLibro) {
        this.repositoryLibro = repositoryLibro;
    }

    @Override
    public Iterable<Libro> findAll() {
        return repositoryLibro.findAll();
    }

}
