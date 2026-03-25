package com.laundry.system.dto;

import com.laundry.system.entity.OrderItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Long customerId;
    private Double total;
    private String orderType;
    private List<OrderItemEntity> items;
}