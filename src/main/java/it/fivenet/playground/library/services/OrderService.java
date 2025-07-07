package it.fivenet.playground.library.services;


import it.fivenet.playground.library.domain.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {

    Order newOrder(Order order);

    Optional<Order> findById(Long id);


    Optional<Order> deleteById(Long id);


    Collection<Order> findAll();


    void save(Order order);
}

