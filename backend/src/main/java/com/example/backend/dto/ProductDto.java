package com.example.backend.dto;

import com.example.backend.entity.product.Category;

import java.util.Date;
import java.util.List;

public class ProductDto {

    private Long id;

    private Long id_SPCT;

    private String name_product;

    private Float price;

    private String origin;

    private Integer status;

    private Date create_date;

    private String created_by;


    private Category category;

    private Long  category_id;



    //Dùng để add to cart bên phía customer


    private Long product_id;

    private int quantityDaChon;

    private int donGia;

    private int quantity;

    private int total_money;

    private Long id_bill;

    private Integer quantityHienCo;

    private Long anh_id;

    private String anh_san_pham;

    private String email_user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_SPCT() {
        return id_SPCT;
    }

    public void setId_SPCT(Long id_SPCT) {
        this.id_SPCT = id_SPCT;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getQuantityDaChon() {
        return quantityDaChon;
    }

    public void setQuantityDaChon(int quantityDaChon) {
        this.quantityDaChon = quantityDaChon;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public Long getId_bill() {
        return id_bill;
    }

    public void setId_bill(Long id_bill) {
        this.id_bill = id_bill;
    }

    public Integer getQuantityHienCo() {
        return quantityHienCo;
    }

    public void setQuantityHienCo(Integer quantityHienCo) {
        this.quantityHienCo = quantityHienCo;
    }

    public Long getAnh_id() {
        return anh_id;
    }

    public void setAnh_id(Long anh_id) {
        this.anh_id = anh_id;
    }

    public String getAnh_san_pham() {
        return anh_san_pham;
    }

    public void setAnh_san_pham(String anh_san_pham) {
        this.anh_san_pham = anh_san_pham;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public ProductDto() {
        this.id = id;
        this.id_SPCT = id_SPCT;
        this.name_product = name_product;
        this.price = price;
        this.origin = origin;
        this.status = status;
        this.create_date = create_date;
        this.created_by = created_by;
        this.category = category;
        this.category_id = category_id;
        this.product_id = product_id;
        this.quantityDaChon = quantityDaChon;
        this.donGia = donGia;
        this.quantity = quantity;
        this.total_money = total_money;
        this.id_bill = id_bill;
        this.quantityHienCo = quantityHienCo;
        this.anh_id = anh_id;
        this.anh_san_pham = anh_san_pham;
        this.email_user = email_user;
    }
}
