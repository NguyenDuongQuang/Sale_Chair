package com.example.backend.entity.bill;

import com.example.backend.entity.Base;
import com.example.backend.entity.user.Customer;
import com.example.backend.entity.user.Staff;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill")

public class Bill extends Base implements Serializable {
    @Column(name = "bill_code", columnDefinition = "nvarchar(256) null")
    private String bill_code;

    @Column(name = "note", columnDefinition = "nvarchar(50) null")
    private String note;

    @Column(name = "name_person", columnDefinition = "nvarchar(256) null")
    private String name_person;

    @Column(name = "email", columnDefinition = "nvarchar(256) null")
    private String email;

    @Column(name = "phone", columnDefinition = "nvarchar(50) null")
    private String phone;

    @Column(name = "address", columnDefinition = "nvarchar(256) null")
    private String address;

    @Column(name = "price_ship", columnDefinition = "int null")
    private int price_ship;

    @Column(name = "discount", columnDefinition = "int null")
    private int discount;

    @Column(name = "total_order", columnDefinition = "int null")
    private int total_order;

    @Column(name = "total_bill", columnDefinition = "int null")
    private int total_bill;

    @Column(name = "bill_type", columnDefinition = "int null")
    private int bill_type;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;



}
