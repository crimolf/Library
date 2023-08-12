package it.fivenet.library.bootstrap;

import it.fivenet.library.domain.Autore;
import it.fivenet.library.domain.Libro;
import it.fivenet.library.repositories.RepositoryAutore;
import it.fivenet.library.repositories.RepositoryCliente;
import it.fivenet.library.repositories.RepositoryLibro;
import it.fivenet.library.repositories.RepositoryPrenotazione;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class BootstrapData implements CommandLineRunner {

    private final RepositoryAutore repositoryAutore;
    private final RepositoryLibro repositoryLibro;
    private final RepositoryCliente repositoryCliente;
    private final RepositoryPrenotazione repositoryPrenotazione;

    public BootstrapData(RepositoryAutore repositoryAutore, RepositoryLibro repositoryLibro, RepositoryCliente repositoryCliente, RepositoryPrenotazione repositoryPrenotazione) {
        this.repositoryAutore = repositoryAutore;
        this.repositoryLibro = repositoryLibro;
        this.repositoryCliente = repositoryCliente;
        this.repositoryPrenotazione = repositoryPrenotazione;
    }

    @Override
    public void run(String... args) throws Exception{

        Autore eric=new Autore();
        eric.setNome("Eric");
        eric.setCognome("Evans");

        Libro ddd=new Libro();
        ddd.setTitolo("Domain Driven Design");
        ddd.setISBN(12345);


    }


}
