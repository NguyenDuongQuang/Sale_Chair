package com.example.backend.entity.cart;

import com.example.backend.entity.Base;
import com.example.backend.entity.product.Product_Detail;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "cart_detail")
@EntityListeners(AuditingEntityListener.class)
public class Cart_Detail extends Base implements Serializable {
    @Column(name = "price", columnDefinition = "int null")
    private int price;

    @Column(name = "quantity", columnDefinition = "int null")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id",referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_detail_id",referencedColumnName = "id")
    private Product_Detail product_detail;
}
