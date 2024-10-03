package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_by", nullable = false)
    private String createBy;

    @Column(name = "update_by_", nullable = false)
    private String updateBy;

    @Column(name="create_date", nullable = false)
    private Date createDate;

    @Column(name="update_date", nullable = false)
    private Date updateDate;

    @Column(name = "status", nullable = false)
    private Integer status;
}
