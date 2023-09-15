package it.fivenet.playground.library.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "CUSTOMER_ORDER")
public class Order {

    private @Id
    @GeneratedValue Long id;
    private String description;
    @Enumerated(EnumType.STRING)private OrderStatus currentOrderStatus;
    private Long bookId;
    private String customerId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

}
