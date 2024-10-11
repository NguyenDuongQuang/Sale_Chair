package com.example.backend.entity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @Column(name = "create_by", updatable = false)
    private String createBy;

    @Column(name = "update_date", updatable = true)
    private Date updateDate;

    @Column(name = "update_by", updatable = true)
    private String updateBy;

    @Column(name = "is_deleted", columnDefinition = "Bit")
    private Boolean isDeleted;

    public Base() {
    }

    public Base(Long id, Date createDate, String createBy, Date updateDate, String updateBy, boolean isDeleted) {
        this.id = id;
        this.createDate = createDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
