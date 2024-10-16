//package com.example.backend.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long userRoleId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "staff_id",referencedColumnName = "id")
//    private NhanVien staff;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "khach_hang_id",referencedColumnName = "id")
//    private KhachHang khachHang;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_role_id",referencedColumnName = "id")
//    private Role role;
//}
