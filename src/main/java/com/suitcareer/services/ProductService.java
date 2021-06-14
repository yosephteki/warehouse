package com.suitcareer.services;

import javax.transaction.Transactional;

import com.suitcareer.models.entities.Product;
import com.suitcareer.models.repositories.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        // final Product newProduct = new Product();
        if (product.getId() == null) {
            final Product newProduct = findByName(product.getName());
            if (newProduct != null) {
                newProduct.setAmount(product.getAmount() + newProduct.getAmount());
                return productRepo.save(newProduct);
            } else {
                return productRepo.save(product);
            }
        }
        return productRepo.save(product);
    }

    public Product findById(long id) {
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void deleteById(long id) {
        productRepo.deleteById(id);
    }

    public Product findByName(String name) {
        return productRepo.findByNameContains(name);
    }

}
