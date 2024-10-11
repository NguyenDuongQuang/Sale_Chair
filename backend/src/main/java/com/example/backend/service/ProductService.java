package com.example.backend.service;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.product.Product;
import com.example.backend.entity.product.Product_Detail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ProductService {
    List<Product> findAllProduct();

    ResponseEntity<Product> saveEdit(ProductDto productDto);

    ResponseEntity<List<Product>> deleteProduct(Long id);

    ResponseEntity<?> searchAllProduct(String search);

    List<Product> searchDateProduct(String searchDate);

    ResponseEntity<?> createProduct(ProductDto productDto);

    List<Object> chiTietSanPham(long ip_product);

    List<Product_Detail> spct_list();

    ResponseEntity<?> getSanPhamTheoGia(Float gia1, Float gia2);
}
