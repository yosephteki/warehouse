package com.suitcareer.models.repositories;

import com.suitcareer.models.entities.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {

    Product findByNameContains(String name);

}
