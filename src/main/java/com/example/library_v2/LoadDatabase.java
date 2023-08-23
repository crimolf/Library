package com.example.library_v2;


import com.example.library_v2.domain.Libro;
import com.example.library_v2.domain.Ordine;
import com.example.library_v2.repositories.LibroRepository;
import com.example.library_v2.repositories.OrdineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LibroRepository libroRepository, OrdineRepository ordineRepository) {

        return args -> {
            libroRepository.save(new Libro("Bilbo", "Baggins"));
            libroRepository.save(new Libro("Frodo", "Baggins"));

            libroRepository.findAll().forEach(libro -> log.info("Preloaded " + libro));


            ordineRepository.save(new Ordine("Odissea", Status.RESTITUITO));
            ordineRepository.save(new Ordine("Guerra e pace", Status.NOLEGGIATO));

            ordineRepository.findAll().forEach(ordine -> {
                log.info("Preloaded " + ordine);
            });

        };
    }
}