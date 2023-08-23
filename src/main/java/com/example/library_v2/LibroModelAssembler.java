package com.example.library_v2;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.library_v2.controllers.ControllerLibro;
import com.example.library_v2.domain.Libro;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

//converts Libro objects to EntityModel<Libro> objects

@Component
public class LibroModelAssembler implements RepresentationModelAssembler<Libro, EntityModel<Libro>> {
    @Override
    public EntityModel<Libro> toModel(Libro libro) {

        return EntityModel.of(libro, //
                linkTo(methodOn(ControllerLibro.class).one(libro.getId())).withSelfRel(),
                linkTo(methodOn(ControllerLibro.class).all()).withRel("libri"));
    }
}
