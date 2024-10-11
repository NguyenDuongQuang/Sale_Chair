package com.example.backend.service;

import com.example.backend.entity.product.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category>findByAll();

    ResponseEntity<Category>editCategory(Category category);

    ResponseEntity<Category>saveCategory(Category category);

    ResponseEntity<List<Category>>deleteCategory(Long id);

}
