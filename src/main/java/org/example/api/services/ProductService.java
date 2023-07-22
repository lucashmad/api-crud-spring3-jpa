package org.example.api.services;

import org.example.api.entities.Products;
import org.example.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> findAll(){
        return productRepository.findAll();
    }

    public Products findById(Long id){
        Optional<Products> object = productRepository.findById(id);
        return object.get();
    }
}
