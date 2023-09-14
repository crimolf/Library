package it.fivenet.playground.library.common;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import it.fivenet.playground.library.controllers.BookController;
import it.fivenet.playground.library.domain.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

//converts Libro objects to EntityModel<Libro> objects

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {
    @Override
    public EntityModel<Book> toModel(Book book) {

        return EntityModel.of(book, //
                linkTo(methodOn(BookController.class).one(book.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
    }
}
