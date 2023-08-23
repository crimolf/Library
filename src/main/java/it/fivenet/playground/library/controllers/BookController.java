package it.fivenet.playground.library.controllers;

import java.util.List;
import java.util.stream.Collectors;

import it.fivenet.playground.library.LibroModelAssembler;
import it.fivenet.playground.library.LibroNotFoundException;
import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.repositories.LibroRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
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
    private final LibroRepository repository;
    private final LibroModelAssembler assembler;

    BookController(LibroRepository repository, LibroModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/libri")
    public CollectionModel<EntityModel<Book>> all() {

        List<EntityModel<Book>> libri = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(libri, linkTo(methodOn(BookController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/libri")
    ResponseEntity<?> newLibro(@RequestBody Book newBook) {

        EntityModel<Book> entityModel = assembler.toModel(repository.save(newBook));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // Single item

    @GetMapping("/libri/{id}")
    public EntityModel<Book> one(@PathVariable Long id) {

        Book book = repository.findById(id) //
                .orElseThrow(() -> new LibroNotFoundException(id));

        return assembler.toModel(book);
    }

    @PutMapping("/libri/{id}")
    ResponseEntity<?> replaceLibro(@RequestBody Book newBook, @PathVariable Long id) {

        Book updatedBook = repository.findById(id) //
                .map(book -> {
                    book.setTitolo(newBook.getTitolo());
                    book.setTesto(newBook.getTesto());
                    return repository.save(book);
                }) //
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });

        EntityModel<Book> entityModel = assembler.toModel(updatedBook);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/libri/{id}")
    ResponseEntity<?> deleteLibro(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}