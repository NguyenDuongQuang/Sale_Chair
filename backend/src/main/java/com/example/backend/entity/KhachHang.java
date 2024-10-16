package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "khach_hang")
@Entity
public class KhachHang extends Base  {
    @Column(name = "ho_ten", columnDefinition = "nvarchar(50) not null")
    private String hoTen;

    @Column(name = "so_dien_thoai", columnDefinition = "nvarchar(10) null")
    private String soDienThoai;

    @Column(name = "email", columnDefinition = "nvarchar(200) null")
    private String email;

    @Column(name = "ngay_sinh", columnDefinition = "Date null")
    private Date ngaySinh;

    @Column(name = "dia_chi", columnDefinition = "nvarchar(250) null")
    private String diaChi;

    @Column(name = "mat_khau", columnDefinition = "nvarchar(250) null")
    private String matKhau;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "khachHang")
//    @JsonIgnore
//    private Set<UserRole> userRoles = new HashSet<>();
}
