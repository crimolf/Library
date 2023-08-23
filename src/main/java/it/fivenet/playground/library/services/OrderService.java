package it.fivenet.playground.library.services;


import it.fivenet.playground.library.domain.Order;

import java.util.Optional;

public interface OrderService {

    public Long newOrder(Order order);

    Optional<Order> findById(Long id);

    public void returnBook(Long orderId);


}
