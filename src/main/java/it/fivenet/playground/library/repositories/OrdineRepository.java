package it.fivenet.playground.library.repositories;

import it.fivenet.playground.library.domain.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
}