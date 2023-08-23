package it.fivenet.playground.library.controllers;

import it.fivenet.playground.library.common.OrderModelAssembler;
import it.fivenet.playground.library.exceptions.OrderNotFoundException;
import it.fivenet.playground.library.domain.OrderStatus;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderModelAssembler assembler;



    @GetMapping("/ordini")
    public CollectionModel<EntityModel<Order>> all() {

        List<EntityModel<Order>> orders = orderService.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(orders, //
                linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    @GetMapping("/ordini/{id}")
    public EntityModel<Order> one(@PathVariable Long id) {

        Order order = orderService.findById(id) //
                .orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/ordini")
    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order) {
        Long orderId=orderService.newOrder(order);
        return ResponseEntity //
                .created(linkTo(methodOn(OrderController.class).one(orderId)).toUri()) //
                .body(assembler.toModel(order));
    }
    @DeleteMapping("/ordini/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id) {

        Optional<Order> order = orderService.findById(id) ;



        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't cancel an order that is in the " + order.get().getCurrentOrderStatus() + " status"));
    }

    @PutMapping("/ordini/{id}/returned")
    public ResponseEntity<?> returned(@PathVariable Long id) {

        Optional<Order>order = orderService.findById(id) ;

        if (order.get().getCurrentOrderStatus() == OrderStatus.NOLEGGIATO) {
            order.get().setCurrentOrderStatus(OrderStatus.NOLEGGIATO);
            return ResponseEntity.ok(assembler.toModel(orderService.save(order)));
        }

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't complete an order that is in the " + order.getStatus() + " status"));
    }
}
