//package com.example.backend.controller.security;
//
//import com.example.backend.config.JwtUtils;
//import com.example.backend.entity.user.Customer;
//import com.example.backend.entity.user.Staff;
//import com.example.backend.helper.UserNotFoundException;
//import com.example.backend.model.request.JwtRequest;
//import com.example.backend.model.response.JwtResponse;
//import com.example.backend.repository.user.CustomerRepository;
//import com.example.backend.repository.user.StaffRepository;
//import com.example.backend.service.Impl.StaffServiceImpl;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@RestController
//@CrossOrigin("*")
//public class AuthenticateController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private StaffServiceImpl staffDetailsService;
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Autowired
//    private StaffRepository staffRepository;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    // generte token
//    @SneakyThrows
//    @PostMapping("/login")
//    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
//        try {
//            authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
//            UserDetails userDetails = this.staffDetailsService.loadUserByUsername(jwtRequest.getEmail());
//            String token = this.jwtUtils.generateToken(userDetails);
//            return ResponseEntity.ok(new JwtResponse(token));
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
//        }
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        Staff nhanVien = this.staffRepository.findByEmail(username);
//        if (nhanVien != null) {
//            if (nhanVien.getStatus() == 1) {
//                throw new DisabledException("Nhân viên Này Đã Nghỉ");
//            }
//        } else {
//            Customer customer = this.customerRepository.findByEmail(username);
//            if (customer == null) {
//                throw new BadCredentialsException("Thông Tin Đăng Nhập Không Hợp Lệ");
//            }
//        }
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Error");
//        }
//    }
//
//    // return the details of current user
//    @GetMapping("/current-user")
//    public Staff getCurrentUser(Principal principal) {
//        return (Staff) this.staffDetailsService.loadUserByUsername(principal.getName());
//    }
//}
