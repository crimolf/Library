package it.fivenet.library.services;

import it.fivenet.library.domain.Cliente;

public interface ServizioCliente {
    Iterable<Cliente> findAll();

}
