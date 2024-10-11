package com.example.backend.controller.admin;

import com.example.backend.entity.product.Product;
import com.example.backend.entity.user.Address;
import com.example.backend.entity.user.Customer;
import com.example.backend.repository.user.AddressRepository;
import com.example.backend.repository.user.CustomerRepository;
import com.example.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/get-all")
    public List<Customer> listCustomer() {
        return customerService.findAllCustomer();
    }

    @PostMapping("/add")
    public ResponseEntity<Customer>addCus(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/edit/{id}")
    public Customer edit(@PathVariable("id") Long id){
        return customerRepository.findByID(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer>updateCuss(@RequestBody Customer customer){
        return customerService.saveEditCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Customer>> deleteCus(@PathVariable("id") Long id){
        return customerService.deleteCustomer(id);
    }

    @RequestMapping("/search={search}")
    public List<Customer> searchAllCustomer(@PathVariable("search") String search) {
        return customerService.searchAllCustomer(search);
    }

    @RequestMapping("/searchDate={searchDate}")
    public List<Customer> searchDateCustomer(@PathVariable("searchDate") String searchDate) {
        return customerService.searchDateCustomer(searchDate);
    }

    @RequestMapping("/addAddress")
    public String addAddress(@RequestParam("address") String address,
                             @RequestParam("customer_id") long customer_id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer_id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            Address add = new Address();
            add.setCustomer(customer);
            add.setAddress(address);
            add.setAddress_default(false);
            addressRepository.save(add);
        }
        return "add address done";
    }

    @PostMapping("/them-dia-chi-mac-dinh")
    public String setAddress(@RequestParam("address_id") long address_id,
                             @RequestParam("customer_id") long customer_id) {
        List<Address> addresses = addressRepository.findByCustomerID(customer_id);
        for (Address add : addresses) {
            add.setAddress_default(false);
            addressRepository.save(add);
        }

        Address diaChi = addressRepository.findbyCustomerAndID(customer_id, address_id);
        diaChi.setAddress_default(true);
        addressRepository.save(diaChi);
        return "true";
    }
}
