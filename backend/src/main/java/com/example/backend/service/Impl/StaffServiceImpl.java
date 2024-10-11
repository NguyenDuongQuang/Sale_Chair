//package com.example.backend.service.Impl;
//
//import com.example.backend.dto.UserDTO;
//import com.example.backend.entity.user.Customer;
//import com.example.backend.entity.user.Staff;
//import com.example.backend.repository.user.CustomerRepository;
//import com.example.backend.repository.user.StaffRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StaffServiceImpl implements UserDetailsService {
//    @Autowired
//    StaffRepository staffRepository;
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Staff staff = this.staffRepository.findByEmail(username);
//        if (staff != null) {
//            UserDTO dto = new UserDTO();
//            dto.setName(staff.getName());
//            dto.setEmail(staff.getEmail());
//            dto.setPassword(staff.getPassword());
//            dto.setRole(staff.getUserRoles());
//            dto.setPhone(staff.getPhone());
//            return dto;
//        }
//
//        Customer customer = this.customerRepository.findByEmail(username);
//        if (customer != null) {
//            UserDTO dto = new UserDTO();
//            dto.setName(customer.getName());
//            dto.setEmail(customer.getEmail());
//            dto.setPassword(customer.getPassword());
//            dto.setRole(customer.getUserRoles());
//            dto.setPhone(customer.getPhone());
//            return dto;
//        }
//
//        throw new UsernameNotFoundException("Thông Tin Đăng Nhập Không Đúng");
//
//    }
//}
