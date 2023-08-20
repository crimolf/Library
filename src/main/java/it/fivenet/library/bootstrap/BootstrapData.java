package it.fivenet.library.bootstrap;


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import it.fivenet.library.domain.Autore;
import it.fivenet.library.domain.Cliente;
import it.fivenet.library.domain.Libro;
import it.fivenet.library.domain.Prenotazione;
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


    public BootstrapData(RepositoryAutore authorRepository, RepositoryLibro repositoryLibro, RepositoryCliente repositoryCliente, RepositoryPrenotazione repositoryPrenotazione) {
        this.repositoryAutore = authorRepository;
        this.repositoryLibro = repositoryLibro;
        this.repositoryCliente=repositoryCliente;
        this.repositoryPrenotazione=repositoryPrenotazione;

    }

    @Override
    public void run(String... args) throws Exception {


        Autore eric = new Autore();
        eric.setNome("Eric");
        eric.setCognome("Evans");

        Libro ddd = new Libro();
        ddd.setTitolo("Domain Driven Design");
        ddd.setISBN(123456);

        Cliente paolo = new Cliente();
        paolo.setCodFis("1sf34fh");
        paolo.setNome("paolo");
        paolo.setCognome("bianchi");
        paolo.setResidenza("via generica 24");

        Prenotazione prenotazione1= new Prenotazione();
        prenotazione1.setIdP(1);
        prenotazione1.setRestituito(false);

        Autore ericSaved = repositoryAutore.save(eric);
        Libro dddSaved = repositoryLibro.save(ddd);
        Cliente paoloSaved=repositoryCliente.save(paolo);
        Prenotazione prenotazione1Saved= repositoryPrenotazione.save(prenotazione1);




        Autore rod = new Autore();
        rod.setNome("Rod");
        rod.setCognome("Johnson");

        Libro noEJB = new Libro();
        noEJB.setTitolo("J2EE Development without EJB");
        noEJB.setISBN(54757585);

        Autore rodSaved = repositoryAutore.save(rod);
        Libro noEJBSaved = repositoryLibro.save(noEJB);



/*
        ericSaved.getLibri().add(dddSaved);
        rodSaved.getLibri().add(noEJBSaved);
        dddSaved.getAutori().add(ericSaved);
        noEJBSaved.getAutori().add(rodSaved);

        repositoryAutore.save(ericSaved);
        repositoryAutore.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Autore Count: " + repositoryAutore.count());
        System.out.println("Libri Count: " + repositoryLibro.count());

*/
    }
}