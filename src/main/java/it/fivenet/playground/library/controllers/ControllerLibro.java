package it.fivenet.playground.library.controllers;

import java.util.List;
import java.util.stream.Collectors;

import it.fivenet.playground.library.LibroModelAssembler;
import it.fivenet.playground.library.LibroNotFoundException;
import it.fivenet.playground.library.domain.Libro;
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
public class ControllerLibro {
    private final LibroRepository repository;
    private final LibroModelAssembler assembler;

    ControllerLibro(LibroRepository repository, LibroModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/libri")
    public CollectionModel<EntityModel<Libro>> all() {

        List<EntityModel<Libro>> libri = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(libri, linkTo(methodOn(ControllerLibro.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/libri")
    ResponseEntity<?> newLibro(@RequestBody Libro newLibro) {

        EntityModel<Libro> entityModel = assembler.toModel(repository.save(newLibro));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // Single item

    @GetMapping("/libri/{id}")
    public EntityModel<Libro> one(@PathVariable Long id) {

        Libro libro = repository.findById(id) //
                .orElseThrow(() -> new LibroNotFoundException(id));

        return assembler.toModel(libro);
    }

    @PutMapping("/libri/{id}")
    ResponseEntity<?> replaceLibro(@RequestBody Libro newLibro, @PathVariable Long id) {

        Libro updatedLibro = repository.findById(id) //
                .map(libro -> {
                    libro.setTitolo(newLibro.getTitolo());
                    libro.setTesto(newLibro.getTesto());
                    return repository.save(libro);
                }) //
                .orElseGet(() -> {
                    newLibro.setId(id);
                    return repository.save(newLibro);
                });

        EntityModel<Libro> entityModel = assembler.toModel(updatedLibro);

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