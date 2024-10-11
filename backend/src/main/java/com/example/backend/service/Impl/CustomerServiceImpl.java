package com.example.backend.service.Impl;

import com.example.backend.controller.message.Message;
import com.example.backend.dto.CustomerDto;
import com.example.backend.entity.cart.Cart;
import com.example.backend.entity.user.Customer;
import com.example.backend.repository.cart.CartRepository;
import com.example.backend.repository.product.CategoryRepository;
import com.example.backend.repository.user.CustomerRepository;
import com.example.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
    @Override
    public ResponseEntity<Customer> saveEditCustomer(Customer customer) {

        String errorMessage;
        Message errorResponse;
//        Optional<Customer>checkMail=Optional.ofNullable(customerRepository.findByEmail(customer.getEmail()));
//        if(checkMail.isPresent()){
//            errorMessage="Email đã tồn tại";
//            errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
//            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
//        }
        if(customer.getName()==null||customer.getAddress()==null||customer.getEmail()==null||customer.getBirthDay()==null||customer.getPassword()==null||customer.getPhone()==null){
            errorMessage="Vui Lòng Nhập Đầy Đủ Thông Tin";
            errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        if(customer.getPhone().length()!=10){
            errorMessage="Phone Phải Đủ 10 Số";
            errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        String email = customer.getEmail();
        String emailRegex = "^[A-Za-z0-9+_.-]+@.+";//kiểm tra định dạng email
        Pattern pattern = Pattern.compile(emailRegex);//tạo Pattern để kiểm tra email
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            errorMessage = "Địa chỉ Eamil không đúng định dạng";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Date currentDate = new Date();
        Date dateOfBirth = customer.getBirthDay();

        if (dateOfBirth.after(currentDate)) {
            errorMessage = "Ngày Sinh Không Được Quá Ngày Hiện tại";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        try {
            Optional<Customer> optional=customerRepository.findById(customer.getId());
            if(optional.isPresent()){
                Customer cus=optional.get();
                cus.setName(customer.getName());
                cus.setAddress(customer.getAddress());
                cus.setEmail(customer.getEmail());
                cus.setBirthDay(customer.getBirthDay());
                cus.setPhone(customer.getPhone());
                cus.setStatus(customer.getStatus());
                cus.setDeleted(customer.isDeleted());
//                cus.setPassword(customer.getPassword());
//            cus.setPassword(passwordEncoder.encode(customer.getPassword()));
                customerRepository.save(cus);
                return ResponseEntity.ok(cus);
            }
            else {
                return ResponseEntity.notFound().build();
            }

        }
        catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Customer>> deleteCustomer(Long id) {

       try{
           Optional<Customer>optional=customerRepository.findById(id);
           if(optional.isPresent()) {
               Customer customer=new Customer();
               customer.setDeleted(true);
               customerRepository.save(customer);
               List<Customer> list=customerRepository.findAll();
               return ResponseEntity.ok(list);
           }
           else {
               return ResponseEntity.notFound().build();
           }
       }catch (Exception e){
           return new  ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
       }
    }

    @Override
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        String errorMessage;
        Message errorResponse;
        Optional<Customer>checkMail=Optional.ofNullable(customerRepository.findByEmail(customer.getEmail()));
            if(checkMail.isPresent()){
            errorMessage="Email đã tồn tại";
            errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
            if(customer.getName()==null||customer.getAddress()==null||customer.getEmail()==null||customer.getBirthDay()==null||customer.getPassword()==null||customer.getPhone()==null){
                errorMessage="Vui Lòng Nhập Đầy Đủ Thông Tin";
                errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
            }
            if(customer.getPhone().length()!=10){
                errorMessage="Phone Phải Đủ 10 Số";
                errorResponse=new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
            }
        String email = customer.getEmail();
        String emailRegex = "^[A-Za-z0-9+_.-]+@.+";//kiểm tra định dạng email
        Pattern pattern = Pattern.compile(emailRegex);//tạo Pattern để kiểm tra email
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            errorMessage = "Địa chỉ Eamil không đúng định dạng";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Date currentDate = new Date();
        Date dateOfBirth = customer.getBirthDay();

        if (dateOfBirth.after(currentDate)) {
            errorMessage = "Ngày Sinh Không Được Quá Ngày Hiện tại";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        try {
            Customer cus=new Customer();
            cus.setName(customer.getName());
            cus.setAddress(customer.getAddress());
            cus.setEmail(customer.getEmail());
            cus.setBirthDay(customer.getBirthDay());
            cus.setPhone(customer.getPhone());
            cus.setPassword(customer.getPassword());
            cus.setStatus(1);
            cus.setDeleted(false);
//            cus.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(cus);

            Cart cart= new Cart();
            cart.setCustomer(cus);
            cartRepository.save(cart);
            return ResponseEntity.ok(cus);
        }
        catch (Exception e){
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Customer> searchAllCustomer(String search) {

        List<Customer> customerAll = customerRepository.findCustomerAll(search);
        return customerAll;
    }

    @Override
    public List<Customer> searchDateCustomer(String searchDate) {
        LocalDate searchdate = LocalDate.parse(searchDate);
        List<Customer> customerDate = customerRepository.findCustomerDate(searchdate);
        return customerDate;
    }

    @Override
    public ResponseEntity Register(Customer create) {
        return null;
    }
}
