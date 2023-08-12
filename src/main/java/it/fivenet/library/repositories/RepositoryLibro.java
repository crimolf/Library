package it.fivenet.library.repositories;

import it.fivenet.library.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryLibro extends CrudRepository <Libro, int>{
}
