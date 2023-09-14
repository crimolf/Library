package it.fivenet.playground.library.common;
import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.domain.OrderStatus;
import it.fivenet.playground.library.repositories.BookRepository;
import it.fivenet.playground.library.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import it.fivenet.playground.library.util.OrderFunctions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static it.fivenet.playground.library.domain.OrderStatus.NOLEGGIATO;
import static java.time.Month.*;
import static java.time.temporal.TemporalAdjusters.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, OrderRepository orderRepository) {

        return args -> {
            /*bookRepository.save(Book.builder().numberBookInStock(100).titolo("signore degli anelli").testo("lorem ispum").numberBooksOut(19).build());
            bookRepository.save(Book.builder().numberBookInStock(101).titolo("bibbia").testo("lorem ispum").numberBooksOut(19).build());

            bookRepository.findAll().forEach(book -> log.info("Preloaded " + book));


            orderRepository.save(Order.builder().description("esempio di descrizione ordine1").currentOrderStatus(NOLEGGIATO).creationDate(LocalDateTime.of(2023,AUGUST,28,15,30,40,50000)).lastUpdateDate(LocalDateTime.of(2023,AUGUST,30,9,15,30,10000)).build());
            orderRepository.save(Order.builder().description("esempio di descrizione ordine2").currentOrderStatus(NOLEGGIATO).creationDate(LocalDateTime.of(2021,AUGUST,28,15,30,40,50000)).lastUpdateDate(LocalDateTime.of(2021,AUGUST,30,9,15,30,10000)).build());
*/

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}
