package com.laundry.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private String itemType; // SERVICE / PRODUCT / ADDON

    private Long itemId;

    private Integer quantity;

    private Double price;

    private Double subtotal;
}