package com.example.backend.controller.admin;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.product.Category;
import com.example.backend.entity.product.Product;
import com.example.backend.repository.product.ProductRepository;
import com.example.backend.repository.product.Product_ImageRepository;
import com.example.backend.service.ProductService;
import com.example.backend.validator.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Product_ImageRepository product_imageRepository;

    @GetMapping("/get-all")
    public ResponseEntity<?> getProduct() {
        List<Product> list = productRepository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product sp : list) {
            ProductDto sanPhamDTO = new ProductDto();
            sanPhamDTO.setId(sp.getId());
            sanPhamDTO.setName_product(sp.getName());
            sanPhamDTO.setPrice(sp.getPrice());
            sanPhamDTO.setStatus(sp.getStatus());
            String hinh_anh = product_imageRepository.getTenAnhSanPham_HienThiDanhSach(sp.getId());
            sanPhamDTO.setAnh_san_pham(hinh_anh);

            dtoList.add(sanPhamDTO);
        }
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<?>add(@RequestBody ProductDto productDto){
        ResponseEntity<?>checkResponse= ProductValidate.checkTaoSanPham(productDto);
        if (!checkResponse.getStatusCode().is2xxSuccessful()) {
            return checkResponse;
        } else {
            return productService.createProduct(productDto);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/edit/{id}")
    private Product edit(@PathVariable("id") Long id){
        return productRepository.findByID(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody ProductDto productDto){
        return productService.saveEdit(productDto);
    }

}
