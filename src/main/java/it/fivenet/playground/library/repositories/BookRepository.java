package it.fivenet.playground.library.repositories;
import it.fivenet.playground.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;

public interface BookRepository extends JpaRepository<Book, Long> {

}
