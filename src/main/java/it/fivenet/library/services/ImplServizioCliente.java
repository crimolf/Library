package it.fivenet.library.services;

import it.fivenet.library.domain.Cliente;
import it.fivenet.library.repositories.RepositoryCliente;
import org.springframework.stereotype.Service;

@Service
public class ImplServizioCliente implements ServizioCliente{
    private final RepositoryCliente repositoryCliente;

    public ImplServizioCliente(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return repositoryCliente.findAll();
    }

}
