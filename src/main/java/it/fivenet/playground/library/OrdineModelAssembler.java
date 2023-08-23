package it.fivenet.playground.library;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import it.fivenet.playground.library.controllers.OrdineController;
import it.fivenet.playground.library.domain.Ordine;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
@Component
public class OrdineModelAssembler implements RepresentationModelAssembler<Ordine, EntityModel<Ordine>> {
    @Override
    public EntityModel<Ordine> toModel(Ordine order) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Ordine> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrdineController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrdineController.class).all()).withRel("orders"));

        // Conditional links based on state of the order

        if (order.getStatus() == Status.NOLEGGIATO) {
            orderModel.add(linkTo(methodOn(OrdineController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrdineController.class).complete(order.getId())).withRel("complete"));
        }

        return orderModel;
    }
}

