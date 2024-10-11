package com.example.backend.service.Impl;

import com.example.backend.controller.message.Message;
import com.example.backend.entity.user.Role;
import com.example.backend.entity.user.Staff;
import com.example.backend.entity.user.User_Role;
import com.example.backend.repository.user.RoleRepository;
import com.example.backend.repository.user.StaffRepository;
import com.example.backend.repository.user.UserRoleRepository;
import com.example.backend.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StafServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAllStaff();
    }

    @Override
    public ResponseEntity<Staff> saveStaff(Staff staffCreate) {

        String errorMessage ;
        Message errorRespone;

        Optional<Staff>checkMail=Optional.ofNullable(staffRepository.findByEmail(staffCreate.getEmail()));
        if(checkMail.isPresent()) {
            errorMessage="Email đã tồn tại";
            errorRespone=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        if(staffCreate.getName()==null||staffCreate.getEmail()==null||staffCreate.getAddress()==null||staffCreate.getPassword()==null||staffCreate.getPhone()==null||staffCreate.getBirthDay()==null){
            errorMessage="Vui Lòng Nhập Đầy Đủ Thông Tin";
            errorRespone=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        if(staffCreate.getPhone().length()!=10){
            errorMessage="Phone Phải Đủ 10 Số";
            errorRespone=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        //email
        String email = staffCreate.getEmail();
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            errorMessage = "Mail không đúng định dạng";
            errorRespone = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }

        //dateOfbirth
        Date currentDate = new Date();
        Date dateOfBirth = staffCreate.getBirthDay();

        if (dateOfBirth.after(currentDate)) {
            errorMessage = "Ngày Sinh Không Được Quá Ngày Hiện tại";
            errorRespone = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        try {
            Staff staff = new Staff();
            staff.setName(staffCreate.getName());
            staff.setEmail(staffCreate.getEmail());
            staff.setAddress(staffCreate.getAddress());
            staff.setPassword(staffCreate.getPassword());
            staff.setPhone(staffCreate.getPhone());
            staff.setBirthDay(staffCreate.getBirthDay());
            staff.setDeleted(false);
            staffRepository.save(staff);
//
//
//            Role role = roleRepository.find("STAFF");
//
//            Set<User_Role> userRoleSet = new HashSet<>();
//            User_Role userRole = new User_Role();
//            userRole.setRole(role);
//            userRole.setStaff(staff);
//            userRoleSet.add(userRole);
//            userRoleRepository.save(userRole);
            return new ResponseEntity<>(staff, HttpStatus.OK);

        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Staff> editStaff(Staff staffEdit) {
        String errorMessage ;
        Message errorRespone;


        if(staffEdit.getName()==null||staffEdit.getEmail()==null||staffEdit.getAddress()==null||staffEdit.getPassword()==null||staffEdit.getPhone()==null||staffEdit.getBirthDay()==null){
            errorMessage="Vui Lòng Nhập Đầy Đủ Thông Tin";
            errorRespone=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        if(staffEdit.getPhone().length()!=10){
            errorMessage="Phone Phải Đủ 10 Số";
            errorRespone=new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        //email
        String email = staffEdit.getEmail();
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            errorMessage = "Mail không đúng định dạng";
            errorRespone = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }

        //dateOfbirth
        Date dateC = new Date();
        Date dateOfBirth = staffEdit.getBirthDay();
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = Period.between(birthDate, currentDate).getYears();

        if(age <= 16){
            errorMessage = "Nhân Viên Dưới 16 Tuổi Không Được Làm Việc";
            errorRespone = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }


        if (dateOfBirth.after(dateC)) {
            errorMessage = "Ngày Sinh Không Được Quá Ngày Hiện Tại";
            errorRespone = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorRespone, HttpStatus.BAD_REQUEST);
        }
        try {
            Optional<Staff> staffOptional = staffRepository.findById(staffEdit.getId());
            if(staffOptional.isPresent()) {
                Staff staff = staffOptional.get();
                staff.setName(staffEdit.getName());
                staff.setEmail(staffEdit.getEmail());
                staff.setAddress(staffEdit.getAddress());
                staff.setPassword(staffEdit.getPassword());
                staff.setPhone(staffEdit.getPhone());
                staff.setBirthDay(staffEdit.getBirthDay());
                staff.setStatus(staffEdit.getStatus());
                staff.setGender(staffEdit.getGender());
                staff.setDeleted(staffEdit.isDeleted());
                staffRepository.save(staff);
                return  ResponseEntity.ok(staff);
            }

            else {
                return ResponseEntity.notFound().build();
            }

        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Staff>> deleteStaff(Long id) {
       try {
           Optional<Staff> staffOptional = staffRepository.findById(id);
           if(staffOptional.isPresent()) {
               Staff staff = staffOptional.get();
               staff.setDeleted(true);
               staffRepository.save(staff);
               return ResponseEntity.ok(findAllStaff());
           }
           else {
               return ResponseEntity.notFound().build();
           }
       }
       catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @Override
    public List<Staff> searchStaffAll(String search) {
        List<Staff> staffList = staffRepository.findStaffAll(search);
        return staffList;
    }

    @Override
    public List<Staff> searchStaffDate(String searchDate) {
        LocalDate searchdate = LocalDate.parse(searchDate);
        List<Staff> staffList = staffRepository.findStaffDate(searchdate);
        return staffList;
    }
}
