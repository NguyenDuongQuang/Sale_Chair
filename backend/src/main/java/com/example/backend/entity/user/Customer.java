package com.example.backend.entity.user;

import com.example.backend.entity.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//public class Customer extends Base implements UserDetails {
public class Customer extends Base {

    @Column(name = "address",columnDefinition = "varchar(450) null")
    private String address;

    @Column(name = "phone", columnDefinition = "varchar(45) null")
    private String phone;

    @Column(name = "email",columnDefinition = "varchar(450) null")
    private String email;

    @Column(name = "name",columnDefinition = "varchar(450) null")
    private String name;

    @Column(name = "password",columnDefinition = "varchar(450) null")
    private String password;

    @Column(name = "birth_day", columnDefinition = "datetime null")
    private Date birthDay;

    @Column(name = "status",columnDefinition = "int null")
    private Integer status;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
//    @JsonIgnore
//    private Set<User_Role> userRoles = new HashSet<>();

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Authority> set = new HashSet<>();
//        this.userRoles.forEach(userRole -> {
//            set.add(new Authority(userRole.getRole().getRoleName()));
//        });
//        return set;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }

}
