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

    public BootstrapData(RepositoryAutore authorRepository, RepositoryLibro repositoryLibro) {
        this.repositoryAutore = authorRepository;
        this.repositoryLibro = repositoryLibro;
    }

    @Override
    public void run(String... args) throws Exception {
        Autore eric = new Autore();
        eric.setNome("Eric");
        eric.setCognome("Evans");

        Libro ddd = new Libro();
        ddd.setTitolo("Domain Driven Design");
        ddd.setISBN(123456);

        Autore ericSaved = repositoryAutore.save(eric);
        Libro dddSaved = repositoryLibro.save(ddd);

        Autore rod = new Autore();
        rod.setNome("Rod");
        rod.setCognome("Johnson");

        Libro noEJB = new Libro();
        noEJB.setTitolo("J2EE Development without EJB");
        noEJB.setISBN(54757585);

        Autore rodSaved = repositoryAutore.save(rod);
        Libro noEJBSaved = repositoryLibro.save(noEJB);

        ericSaved.getLibri().add(dddSaved);
        rodSaved.getLibri().add(noEJBSaved);

        repositoryAutore.save(ericSaved);
        repositoryAutore.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Autore Count: " + repositoryAutore.count());
        System.out.println("Libri Count: " + repositoryLibro.count());


    }
}