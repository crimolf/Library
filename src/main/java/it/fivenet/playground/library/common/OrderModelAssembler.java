package it.fivenet.playground.library.common;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import it.fivenet.playground.library.controllers.OrderController;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.domain.OrderStatus;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        // Conditional links based on state of the order

        if (order.getCurrentOrderStatus() == OrderStatus.NOLEGGIATO) {
            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderController.class).returned(order.getId())).withRel("returned"));
        }

        return orderModel;
    }
}

