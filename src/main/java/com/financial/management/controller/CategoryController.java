package com.financial.management.controller;


import com.financial.management.domain.Category;
import com.financial.management.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.save(category);
    }

    @GetMapping
    public List<Category> list() {
        return service.findAll();
    }
}
