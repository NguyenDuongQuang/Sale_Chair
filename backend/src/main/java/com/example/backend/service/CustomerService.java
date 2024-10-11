package com.example.backend.service;

import com.example.backend.dto.CustomerDto;
import com.example.backend.entity.user.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer>findAllCustomer();

    ResponseEntity<Customer>saveEditCustomer(Customer customer);

    ResponseEntity<List<Customer>> deleteCustomer(Long id);

    ResponseEntity<Customer>createCustomer(Customer customer);

    List<Customer> searchAllCustomer(String search);

    List<Customer> searchDateCustomer(String searchDate);

    ResponseEntity Register(Customer create);
}
