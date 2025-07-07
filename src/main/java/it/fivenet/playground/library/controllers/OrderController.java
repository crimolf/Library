package it.fivenet.playground.library.controllers;


import it.fivenet.playground.library.common.BookModelAssembler;
import it.fivenet.playground.library.common.OrderModelAssembler;
import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.exceptions.OrderNotFoundException;
import it.fivenet.playground.library.domain.OrderStatus;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.repositories.BookRepository;
import it.fivenet.playground.library.repositories.OrderRepository;
import it.fivenet.playground.library.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderModelAssembler assembler;

    OrderController(OrderService orderService, OrderModelAssembler assembler) {
        this.orderService = orderService;
        this.assembler = assembler;
    }


    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return (List<Order>) orderService.findAll();
    }


    @GetMapping("/orders/{id}")
    public EntityModel<Order> one(@PathVariable Long id) {

        Order order = orderService.findById(id) //
                .orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order) {
        order.setCurrentOrderStatus(OrderStatus.NOLEGGIATO);
        order.setCreationDate(LocalDateTime.now());
        order.setLastUpdateDate(LocalDateTime.now());

        Order savedOrder = orderService.newOrder(order); // Ricevi l'oggetto completo

        return ResponseEntity
                .created(linkTo(methodOn(OrderController.class).one(savedOrder.getId())).toUri())
                .body(assembler.toModel(savedOrder)); // Usa l'oggetto salvato
    }
    @DeleteMapping("/orders/{id}")
    public Optional<Order> delete(@PathVariable Long id) {
        return orderService.deleteById(id);
    }

    @PutMapping("/orders/{id}/return")
    public ResponseEntity<Order> returned(@PathVariable Long id) {

        Order updateOrder = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not exist with id: " + id));

        updateOrder.setCurrentOrderStatus(OrderStatus.RESTITUITO);
        updateOrder.setLastUpdateDate(LocalDateTime.now());

        orderService.save(updateOrder);
        return ResponseEntity.ok(updateOrder);
    }

    @PutMapping("/orders/{id}/cancel")
    public ResponseEntity<Order> cancel(@PathVariable Long id) {

        Order updateOrder = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not exist with id: " + id));

        updateOrder.setCurrentOrderStatus(OrderStatus.CANCELLATO);
        updateOrder.setLastUpdateDate(LocalDateTime.now());

        orderService.save(updateOrder);
        return ResponseEntity.ok(updateOrder);
    }






}

