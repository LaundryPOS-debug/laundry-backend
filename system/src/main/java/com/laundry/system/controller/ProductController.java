package com.laundry.system.controller;

import com.laundry.system.entity.ProductEntity;
import com.laundry.system.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ProductEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return repo.save(product);
    }
}