package com.lab.mvc.springbootlist.service;

import com.lab.mvc.springbootlist.model.Product;
import com.lab.mvc.springbootlist.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
