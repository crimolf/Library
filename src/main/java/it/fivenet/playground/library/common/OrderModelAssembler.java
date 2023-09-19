package it.fivenet.playground.library.common;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import it.fivenet.playground.library.controllers.OrderController;
import it.fivenet.playground.library.domain.Order;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

//converts Libro objects to EntityModel<Libro> objects

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {

        return EntityModel.of(order, //
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).getAllOrders()).withRel("orders"));
    }
}
