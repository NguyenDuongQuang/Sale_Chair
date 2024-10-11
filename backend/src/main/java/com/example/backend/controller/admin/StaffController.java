package com.example.backend.controller.admin;

import com.example.backend.entity.user.Staff;
import com.example.backend.repository.user.StaffRepository;
import com.example.backend.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/get-all")
    public List<Staff> getAll(){
        return staffService.findAllStaff();
    }

    @PostMapping("/add")
    public ResponseEntity<Staff>addStaff(@RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }

    @GetMapping("/edit/{id}")
    public Staff edit(@PathVariable("id") Long id){
        return staffRepository.findByID(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Staff> update(@RequestBody Staff staff){
        return staffService.editStaff(staff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Staff>> delete(@PathVariable("id") Long id){
        return staffService.deleteStaff(id);
    }

    @GetMapping("/search/{search}")
    public List<Staff> searchStaff(@PathVariable("search") String search) {
        return staffService.searchStaffAll(search);
    }

    @GetMapping("/searchDate/{searchDate}")
    public List<Staff> searchDateStaff(@PathVariable("searchDate") String searchDate) {
        return staffService.searchStaffDate(searchDate);
    }
}
