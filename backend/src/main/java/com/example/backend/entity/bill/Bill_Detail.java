package com.example.backend.entity.bill;

import com.example.backend.entity.Base;
import com.example.backend.entity.product.Product_Detail;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bill_detail")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Bill_Detail extends Base implements Serializable {

    @Column(name = "price",columnDefinition = "int null")
    private int price;

    @Column(name = "quantity",columnDefinition = "int null")
    private int quantity;

    @Column(name = "total_money",columnDefinition = "int null")
    private int totalMoney;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id")
    private Product_Detail product_detail;

}
