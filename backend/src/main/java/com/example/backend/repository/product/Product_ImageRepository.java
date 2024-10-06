package com.example.backend.repository.product;

import com.example.backend.entity.product.Product_Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_ImageRepository extends JpaRepository<Product_Image,Long> {
}
