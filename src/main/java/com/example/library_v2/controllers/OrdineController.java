package com.example.library_v2.controllers;

import com.example.library_v2.OrdineModelAssembler;
import com.example.library_v2.OrdineNotFoundException;
import com.example.library_v2.Status;
import com.example.library_v2.domain.Ordine;
import com.example.library_v2.repositories.OrdineRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OrdineController {
    private final OrdineRepository orderRepository;
    private final OrdineModelAssembler assembler;

    OrdineController(OrdineRepository orderRepository, OrdineModelAssembler assembler) {

        this.orderRepository = orderRepository;
        this.assembler = assembler;
    }

    @GetMapping("/ordini")
    public CollectionModel<EntityModel<Ordine>> all() {

        List<EntityModel<Ordine>> orders = orderRepository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(orders, //
                linkTo(methodOn(OrdineController.class).all()).withSelfRel());
    }

    @GetMapping("/ordini/{id}")
    public EntityModel<Ordine> one(@PathVariable Long id) {

        Ordine order = orderRepository.findById(id) //
                .orElseThrow(() -> new OrdineNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/ordini")
    ResponseEntity<EntityModel<Ordine>> newOrder(@RequestBody Ordine order) {

        order.setStatus(Status.NOLEGGIATO);
        Ordine newOrder = orderRepository.save(order);

        return ResponseEntity //
                .created(linkTo(methodOn(OrdineController.class).one(newOrder.getId())).toUri()) //
                .body(assembler.toModel(newOrder));
    }
    @DeleteMapping("/ordini/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long id) {

        Ordine order = orderRepository.findById(id) //
                .orElseThrow(() -> new OrdineNotFoundException(id));

        if (order.getStatus() == Status.NOLEGGIATO) {
            order.setStatus(Status.CANCELLATO);
            return ResponseEntity.ok(assembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't cancel an order that is in the " + order.getStatus() + " status"));
    }

    @PutMapping("/ordini/{id}/complete")
    public ResponseEntity<?> complete(@PathVariable Long id) {

        Ordine order = orderRepository.findById(id) //
                .orElseThrow(() -> new OrdineNotFoundException(id));

        if (order.getStatus() == Status.NOLEGGIATO) {
            order.setStatus(Status.RESTITUITO);
            return ResponseEntity.ok(assembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't complete an order that is in the " + order.getStatus() + " status"));
    }
}