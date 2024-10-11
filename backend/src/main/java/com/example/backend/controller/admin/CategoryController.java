package com.example.backend.controller.admin;

import com.example.backend.entity.product.Category;
import com.example.backend.repository.product.CategoryRepository;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().body(categoryService.findByAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/edit/{id}")
    public Optional<Category> edit(@PathVariable("id") Long id) {
        return categoryRepository.findById(id);
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Category>> delete(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }
    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }
}
