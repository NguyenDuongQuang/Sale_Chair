package com.example.backend.service;

import com.example.backend.entity.user.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    List<Staff>findAllStaff();

    ResponseEntity<Staff>saveStaff(Staff staffCreate);

    ResponseEntity<Staff>editStaff(Staff staffEdit);

    ResponseEntity<List<Staff>> deleteStaff(Long id);

    List<Staff> searchStaffAll(String search);

    List<Staff> searchStaffDate(String searchDate);


}
