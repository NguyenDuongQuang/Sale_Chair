package com.example.backend.entity.user;

import com.example.backend.entity.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "address")

public class Address extends Base implements Serializable {
    @Column(name = "address", columnDefinition = "nvarchar(500) null")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @Column(name = "address_default")
    private boolean address_default = false;

}
