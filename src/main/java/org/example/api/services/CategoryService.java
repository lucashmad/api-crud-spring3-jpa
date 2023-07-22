package org.example.api.services;

import org.example.api.entities.Category;
import org.example.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){ // retorna a lista
        return categoryRepository.findAll();
    }

    public Category findById(Long id){ // pesquisa pelo id
        Optional<Category> object = categoryRepository.findById(id);
        return object.get();
    }
}
