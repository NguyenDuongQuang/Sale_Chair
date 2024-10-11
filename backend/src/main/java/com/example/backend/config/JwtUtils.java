//package com.example.backend.config;
//
//import com.example.backend.dto.UserDTO;
//import com.example.backend.entity.user.Address;
//import com.example.backend.entity.user.Customer;
//import com.example.backend.entity.user.Staff;
//import com.example.backend.entity.user.User_Role;
//import com.example.backend.repository.user.AddressRepository;
//import com.example.backend.repository.user.CustomerRepository;
//import com.example.backend.repository.user.StaffRepository;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.util.*;
//import java.util.function.Function;
//
//@Component
//public class JwtUtils {
//    private final SecretKey secretKey;
//
//    @Autowired
//    StaffRepository staffRepository;
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    AddressRepository addressRepository;
//
//    @Value("${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;
//
//    public JwtUtils(@Value("${app.jwtSecret}") String jwtSecret) {
//        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = null;
//        UserDTO userDTO = null;
//        Staff staff = this.staffRepository.findByEmail(userDetails.getUsername());
//        if (staff != null) {
//            userDTO = new UserDTO();
//            userDTO.setEmail(staff.getEmail());
//            userDTO.setName(staff.getName());
//            userDTO.setPassword(staff.getPassword());
//            userDTO.setRole(staff.getUserRoles());
//            userDTO.setPhone(staff.getPhone());
//            claims = new HashMap<>();
//            claims.put("hoTen", userDTO.getName());
//            claims.put("email", userDTO.getEmail());
//            claims.put("role", getRolesAsString(userDTO.getRole()));
//            claims.put("phone", userDTO.getPhone());
//
//        } else {
//            Customer customer = customerRepository.findByEmail(userDetails.getUsername());
//            Address address = addressRepository.getAddress(customer.getId());
//            if (address != null) {
//                if (customer != null) {
//                    userDTO = new UserDTO();
//                    userDTO.setEmail(customer.getEmail());
//                    userDTO.setName(customer.getName());
//                    userDTO.setPassword(customer.getPassword());
//                    userDTO.setRole(customer.getUserRoles());
//                    userDTO.setPhone(customer.getPhone());
//                    userDTO.setAddress(address.getAddress());
//                    claims = new HashMap<>();
//                    claims.put("hoTen", userDTO.getName());
//                    claims.put("email", userDTO.getEmail());
//                    claims.put("role", getRolesAsString(userDTO.getRole()));
//                    claims.put("phone", userDTO.getPhone());
//                    claims.put("address", userDTO.getAddress());
//                } else {
//                    throw new UsernameNotFoundException("Thông tin đăng nhập không hợp lệ!!");
//                }
//            } else if (address == null) {
//                userDTO = new UserDTO();
//                userDTO.setEmail(customer.getEmail());
//                userDTO.setName(customer.getName());
//                userDTO.setPassword(customer.getPassword());
//                userDTO.setRole(customer.getUserRoles());
//                userDTO.setPhone(customer.getPhone());
//                userDTO.setAddress("Không có");
//                claims = new HashMap<>();
//                claims.put("hoTen", userDTO.getName());
//                claims.put("email", userDTO.getEmail());
//                claims.put("role", getRolesAsString(userDTO.getRole()));
//                claims.put("phone", userDTO.getPhone());
//                claims.put("address", userDTO.getAddress());
//            }
//
//        }
//        return createToken(claims);
//    }
//
//    private String createToken(Map<String, Object> claims) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(claims.get("email").toString()) // Đặt Subject thành email hoặc một trường unique khác
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }
//
//    private String getRolesAsString(Set<User_Role> userRoles) {
//        List<String> roles = new ArrayList<>();
//        for (User_Role role : userRoles) {
//            roles.add(role.getRole().getRoleName());
//        }
//        return String.join(",", roles); // Trả về chuỗi các Role, có thể sử dụng dấu phân cách phù hợp
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//}
