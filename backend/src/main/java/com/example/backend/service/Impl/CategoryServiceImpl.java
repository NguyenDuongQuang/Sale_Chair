package com.example.backend.service.Impl;

//import com.example.backend.controller.message.Message;
import com.example.backend.controller.message.Message;
import com.example.backend.entity.product.Category;
import com.example.backend.repository.product.CategoryRepository;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    private boolean isValid(String str) {
        return str.matches("^[a-zA-Z\\d\\s\\S]+$");
    }


    @Override
    public List<Category> findByAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<Category> editCategory(Category category) {
        Category optionaLoaiSanPham = categoryRepository.findByName(category.getName());
        String errorMessage;
        Message errorResponse;

        if (optionaLoaiSanPham != null) {
            errorMessage = " Trùng loại sản phẩm";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        if (category.getName() == null || !isValid(category.getName())) {
            errorMessage = "Nhập không hợp lệ";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }

        try {
            Optional<Category> optional = categoryRepository.findById(category.getId());
            if (optional.isPresent()){
                Category line = optional.get();
                line.setName(category.getName());
                categoryRepository.save(line);
                return ResponseEntity.ok(line);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Category> saveCategory(Category category) {
        Category cate=categoryRepository.findByName(category.getName());
        String errorMessage;
        Message errorResponse;
        if(cate!=null){
            errorMessage="Trùng Category";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return  new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);

        }
        if(category.getName()==null || !isValid(category.getName())){
            errorMessage="Vui Lòng Nhập Đúng Category";
            errorResponse =new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return  new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);

        }
        try {
            Category c =new Category();
            c.setName(category.getName());
            categoryRepository.save(c);
            return new ResponseEntity<>(c, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(),TrayIcon.MessageType.ERROR),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Category>> deleteCategory(Long id) {
        try{
            Optional<Category> optionalCategory=categoryRepository.findById(id);
            if (optionalCategory.isPresent()){
                Category c=optionalCategory.get();
                c.setDeleted(true);
                return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return new ResponseEntity(new Message(e.getMessage(),TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }
}
