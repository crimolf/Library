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
@Table(name = "order_test")
public class Order {

    private @Id
    @Column@GeneratedValue Long id;
    @Column private String description;
    @Column@Enumerated(EnumType.STRING)private OrderStatus currentOrderStatus;
    @Column private LocalDateTime creationDate;
    @Column private LocalDateTime lastUpdateDate;

}
