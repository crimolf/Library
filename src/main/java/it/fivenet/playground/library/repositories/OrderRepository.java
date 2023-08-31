package it.fivenet.playground.library.repositories;
import it.fivenet.playground.library.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}