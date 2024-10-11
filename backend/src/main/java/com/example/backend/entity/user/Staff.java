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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "staff")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//public class Staff extends Base implements UserDetails {
public class Staff extends Base {
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

    @Column(name = "address",columnDefinition = "varchar(45) null")
    private String address;

    @Column(name = "gender",columnDefinition = "bit null")
    private Boolean gender;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "staff")
//    @JsonIgnore
//    private Set<User_Role> userRoles = new HashSet<>();

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Authority>authoritySet=new HashSet<>();
//        this.userRoles.forEach(user_role -> {
//            authoritySet.add(new Authority(user_role.getRole().getRoleName()));
//        });
//        return authoritySet;
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
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
