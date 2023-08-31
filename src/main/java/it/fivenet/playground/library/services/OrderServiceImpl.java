package it.fivenet.playground.library.services;

import it.fivenet.playground.library.domain.OrderStatus;
import it.fivenet.playground.library.domain.Order;
import it.fivenet.playground.library.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Long newOrder(Order order) {
        order.setCurrentOrderStatus(OrderStatus.NOLEGGIATO);

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

        if (order.get().getCurrentOrderStatus() == OrderStatus.NOLEGGIATO) {
            order.get().setCurrentOrderStatus(OrderStatus.RESTITUITO);
            orderRepository.save(order.get());
        }

    }

    @Override
    public Optional<Order> deleteById(Long id) {

        orderRepository.deleteById(id);

        return null;
    }

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll();
    }



    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}


