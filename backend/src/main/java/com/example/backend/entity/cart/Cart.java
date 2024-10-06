package com.example.backend.entity.cart;

import com.example.backend.entity.Base;
import com.example.backend.entity.user.Customer;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
@EntityListeners(AuditingEntityListener.class)
public class Cart extends Base implements Serializable {
    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;
}
