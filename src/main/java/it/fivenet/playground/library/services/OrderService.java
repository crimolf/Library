package it.fivenet.playground.library.services;


import it.fivenet.playground.library.domain.Book;
import it.fivenet.playground.library.domain.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {

    Long newOrder(Order order);

    Optional<Order> findById(Long id);


    Optional<Order> deleteById(Long id);

    public void returnBook(Long orderId);

    Collection<Order> findAll();


    Order save(Order order);
}

