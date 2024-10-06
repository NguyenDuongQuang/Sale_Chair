package com.example.backend.entity.product;

import com.example.backend.entity.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product extends Base implements Serializable {

    @Column(name = "name", columnDefinition = "nvarchar(256) null")
    private String name;

    @Column(name = "note", columnDefinition = "nvarchar(256) null")
    private String note;

    @Column(name = "price", columnDefinition = "nvarchar(256) null")
    private Float price;

    @Column(name = "status",columnDefinition = "int null")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName ="id")
    private Category category;
}
