package com.laundry.system.controller;

import com.laundry.system.dto.OrderRequest;
import com.laundry.system.entity.OrderEntity;
import com.laundry.system.entity.OrderItemEntity;
import com.laundry.system.repository.OrderRepository;
import com.laundry.system.repository.OrderItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderRepository orderRepo;
    private final OrderItemRepository itemRepo;

    public OrderController(OrderRepository orderRepo, OrderItemRepository itemRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
    }

    // CREATE ORDER WITH ITEMS
    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderRequest request) {

        // 1. SAVE ORDER
        OrderEntity order = new OrderEntity();
        order.setCustomerId(request.getCustomerId());
        order.setTotal(request.getTotal());
        order.setPaymentStatus("PAID");
        order.setOrderStatus("NEW");
        order.setOrderType(request.getOrderType());

        OrderEntity savedOrder = orderRepo.save(order);

        // 2. SAVE ITEMS
        for (OrderItemEntity item : request.getItems()) {
            item.setOrderId(savedOrder.getId());
            itemRepo.save(item);
        }

        return savedOrder;
    }

    // GET ALL ORDERS
    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }
}