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

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, OrderRepository orderRepository) {

        return args -> {
            bookRepository.save(Book.builder().titolo("signore degli anelli").testo("lorem ispum").build());
            bookRepository.save(Book.builder().titolo("bibbia").testo("lorem ispum").build());

            bookRepository.findAll().forEach(book -> log.info("Preloaded " + book));


            orderRepository.save(new Order("Odissea", OrderStatus.RESTITUITO));
            orderRepository.save(new Order("Guerra e pace", OrderStatus.NOLEGGIATO));

            orderRepository.findAll().forEach(ordine -> {
                log.info("Preloaded " + ordine);
            });

        };
    }
}
