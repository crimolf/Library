package it.fivenet.library.repositories;

import it.fivenet.library.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryCliente extends CrudRepository<Cliente, String> {
}
