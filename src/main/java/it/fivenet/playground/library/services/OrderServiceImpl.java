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
    public Order newOrder(Order order) {
        order.setCurrentOrderStatus(OrderStatus.NOLEGGIATO);
        return orderRepository.save(order); // Restituisci l'oggetto completo
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<Order> order= orderRepository.findById(id);
        return order;
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
    public void save(Order order) {
        orderRepository.save(order);
    }
}


