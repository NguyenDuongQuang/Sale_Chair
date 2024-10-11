package com.example.backend.dto;

import com.example.backend.entity.product.Product;

import java.util.Date;

public class Product_DetailDto {
    private Long id;

    private Integer quantity;

    private boolean status;

    private Date createdDate;

    private String createdby;

    private Date updatedDate;

    private String updatedby;

    private Product product;

    private long product_id;
}
