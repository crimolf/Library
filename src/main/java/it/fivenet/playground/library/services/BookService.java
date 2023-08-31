package it.fivenet.playground.library.services;


import it.fivenet.playground.library.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface BookService {

    Long newBook(Book book);



    Optional<Book> findById(Long id);


    Optional<Book> deleteById(Long id);

    Book save(Optional<Book> book);


    Collection<Book> findAll();



}
