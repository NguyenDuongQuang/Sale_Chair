package com.example.backend.entity.product;

import com.example.backend.entity.Base;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_image")
@EntityListeners(AuditingEntityListener.class)
public class Product_Image extends Base implements Serializable {

    @Column(name = "image_default",columnDefinition = "bit")
    private Boolean imagesDefault;

    @Column(name = "name",columnDefinition = "nvarchar(256) null")
    private String nameImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
