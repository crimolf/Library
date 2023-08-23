package it.fivenet.playground.library.repositories;
import it.fivenet.playground.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Book, Long> {
}
