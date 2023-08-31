package it.fivenet.playground.library.services;

import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


        @Override
        public Long newBook(Book book) {


        Book newBook = bookRepository.save(book);
        return newBook.getId();
        }


        @Override
        public Optional<Book> findById(Long id) {

        Optional<Book> book= bookRepository.findById(id);


        return book;
        }


    @Override
    public Optional<Book> deleteById(Long id) {

        bookRepository.deleteById(id);

        return null;
    }








        @Override
        public Book save(Optional<Book> book) {
        return null;
        }


    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }


}


