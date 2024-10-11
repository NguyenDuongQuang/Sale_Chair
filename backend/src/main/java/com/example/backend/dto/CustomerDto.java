package com.example.backend.dto;

import lombok.Data;

import java.util.Date;


public class CustomerDto {
    private Long id;

    private String name;

    private String phone;

    private long bill_id;

    private String email;

    private Date birth_day;

    private String address;


    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String phone, long bill_id, String email, Date birth_day, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.bill_id = bill_id;
        this.email = email;
        this.birth_day = birth_day;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getBill_id() {
        return bill_id;
    }

    public void setBill_id(long bill_id) {
        this.bill_id = bill_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
