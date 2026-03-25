package com.laundry.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Double total;

    private String paymentStatus;

    private String orderStatus;

    private String orderType;

    private LocalDateTime createdAt = LocalDateTime.now();
}