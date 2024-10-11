package com.example.backend.service.Impl;

import com.example.backend.controller.message.Message;
import com.example.backend.dto.ProductDto;
import com.example.backend.entity.product.Category;
import com.example.backend.entity.product.Product;
import com.example.backend.entity.product.Product_Detail;
import com.example.backend.repository.product.CategoryRepository;
import com.example.backend.repository.product.ProductRepository;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> saveEdit(ProductDto productDto) {
        String errorMessage ;
        Message errorResponse;
        if(productDto.getPrice()<=0){
            errorMessage="Giá Phải Lớn Hơn 0";
            errorResponse= new Message(errorMessage,TrayIcon.MessageType.ERROR);
            return  new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
        }
        try {
            Optional<Product>optional=productRepository.findById(productDto.getId());
            if(optional.isPresent()){
                Product product=optional.get();
                product.setName(productDto.getName_product());
                product.setPrice(productDto.getPrice());
                product.setCategory(productDto.getCategory());
                productRepository.save(product);
                return ResponseEntity.ok(product);
            }
            else {
                return ResponseEntity.notFound().build();
            }

        }catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(),TrayIcon.MessageType.ERROR),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Product>> deleteProduct(Long id) {
        try{
            Optional<Product> OptionalProduct=productRepository.findById(id);
            if(OptionalProduct.isPresent()){
                Product product=OptionalProduct.get();
                product.setStatus(1);
                product.setDeleted(true);
                productRepository.save(product);
                List<Product> list = productRepository.findAll();
                return ResponseEntity.ok(list);
            }
            else {
                return ResponseEntity.notFound().build();
            }

         }catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
       }
    }

    @Override
    public ResponseEntity<?> searchAllProduct(String search) {
        return null;
    }

    @Override
    public List<Product> searchDateProduct(String searchDate) {
        LocalDate search = LocalDate.parse(searchDate);
        List<Product> list = productRepository.findByDate(search);
        return list;
    }

    @Override
    public ResponseEntity<?> createProduct(ProductDto productDto) {
        Product options = productRepository.checkLap(productDto.getName_product());
        String errorMessage ;
        Message errorResponse;
        if(options!=null) {
            errorMessage ="Trùng Product";
            errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            Map<String,String>responseMap = new HashMap<>();
            responseMap.put("errorMessage",errorMessage);
            return new ResponseEntity(responseMap, HttpStatus.BAD_REQUEST);
        }
        Map<String,Object>responseMap = new HashMap<>();
        Category optionsCategory=categoryRepository.findByID(productDto.getCategory_id());
        Product product=new Product();
        product.setName(productDto.getName_product());
        product.setPrice(productDto.getPrice());
        product.setStatus(1);
        product.setCategory(optionsCategory);
        productRepository.save(product);
        return new ResponseEntity(responseMap, HttpStatus.OK);
    }

    @Override
    public List<Object> chiTietSanPham(long ip_product) {
        return null;
    }

    @Override
    public List<Product_Detail> spct_list() {
        return null;
    }

    @Override
    public ResponseEntity<?> getSanPhamTheoGia(Float gia1, Float gia2) {
        return null;
    }
}
