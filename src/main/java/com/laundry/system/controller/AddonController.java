package com.laundry.system.controller;

import com.laundry.system.entity.AddonEntity;
import com.laundry.system.repository.AddonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addons")
@CrossOrigin
public class AddonController {

    private final AddonRepository repo;

    public AddonController(AddonRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<AddonEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public AddonEntity create(@RequestBody AddonEntity addon) {
        return repo.save(addon);
    }
}