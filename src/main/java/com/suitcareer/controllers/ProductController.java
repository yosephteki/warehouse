package com.suitcareer.controllers;

import com.suitcareer.models.entities.Product;
import com.suitcareer.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Product findByName(@PathVariable("name") String name) {
        return productService.findByName(name);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
