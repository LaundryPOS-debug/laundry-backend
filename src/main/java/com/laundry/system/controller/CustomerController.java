package com.laundry.system.controller;

import com.laundry.system.entity.CustomerEntity;
import com.laundry.system.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CustomerEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public CustomerEntity create(@RequestBody CustomerEntity customer) {
        return repo.save(customer);
    }
}