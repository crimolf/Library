package it.fivenet.playground.library.services;

import it.fivenet.playground.library.OrderModelAssembler;
import it.fivenet.playground.library.OrdineNotFoundException;
import it.fivenet.playground.library.Status;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public Long newOrder(Order order) {
        order.setStatus(Status.NOLEGGIATO);

        Order newOrder = orderRepository.save(order);
        return newOrder.getId();
    }

    @Override
    public Optional<Order> findById(Long id) {

        Optional<Order> order= orderRepository.findById(id);


        return order;
    }

    @Override
    public void returnBook(Long orderId) {

        Optional<Order>order = orderRepository.findById(orderId) ;

        if (order.get().getStatus() == Status.NOLEGGIATO) {
            order.get().setStatus(Status.RESTITUITO);
            orderRepository.save(order.get());
        }

    }
}

