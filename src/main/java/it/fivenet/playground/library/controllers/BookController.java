package it.fivenet.playground.library.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.fivenet.playground.library.common.BookModelAssembler;
import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.exceptions.BookNotFoundException;
import it.fivenet.playground.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {
    private final BookService bookService;
    private final BookModelAssembler assembler;
    private int counterBooksInStock=101;
    private int counterBooksOut=19;

    @Autowired
    BookController(BookService bookService, BookModelAssembler assembler) {
        this.bookService = bookService;
        this.assembler = assembler;
    }




    @GetMapping("/books")
    public CollectionModel<EntityModel<Book>> all() {

        List<EntityModel<Book>> books = bookService.findAll().stream() //
                .map((Book book) -> assembler.toModel((Book) book)) //
                .collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

    @PostMapping("/books")
    ResponseEntity<EntityModel<Book>> newBook(@RequestBody Book book) {
        counterBooksInStock++;
        book.setNumberBookInStock(counterBooksInStock+book.getNumberBookInStock());
        book.setNumberBooksOut(counterBooksOut);
        Long bookId=bookService.newBook(book);

        return ResponseEntity //
                .created(linkTo(methodOn(BookController.class).one(bookId)).toUri()) //
                .body(assembler.toModel(book));

    }




    @GetMapping("/books/{id}")
    public EntityModel<Book> one(@PathVariable Long id) {

        Book book = bookService.findById(id) //
                .orElseThrow(() -> new BookNotFoundException(id));

        return assembler.toModel(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> returned(@PathVariable Long id) {

        Optional<Book>book = bookService.findById(id) ;



        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") );
    }

    @DeleteMapping("/books/{id}")
    public Optional<Book> delete(@PathVariable Long id) {
        counterBooksInStock--;
        return bookService.deleteById(id);
    }


}

