package com.laundry.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addons")
@Data
public class AddonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String details;
    private String status;
}