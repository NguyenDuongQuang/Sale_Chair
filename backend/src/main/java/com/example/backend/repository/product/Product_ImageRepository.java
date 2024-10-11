package com.example.backend.repository.product;

import com.example.backend.entity.product.Product_Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface Product_ImageRepository extends JpaRepository<Product_Image,Long> {
    @Query(value = "select * from product_image where product_id = ? and image_default = true limit 1;", nativeQuery = true)
    Product_Image getFirstAnhByIdSanPham(@Param("idsp")Long idsp);

    @Query(value = "SELECT * FROM product_image WHERE is_deleted = false ORDER BY id DESC", nativeQuery = true)
    List<Product_Image> findAll();

    @Query(value = "select * from product_image where id = ? and is_deleted = false", nativeQuery = true)
    Product_Image findByID(Long id);

    @Query(value = "SELECT * FROM product_image WHERE is_deleted = false AND DATE(started_date) = ?", nativeQuery = true)
    List<Product_Image> findByDate(LocalDate ngayTao);

    @Query(value = "select * from product_image where name = ?", nativeQuery = true)
    Optional<Product_Image> findByName(String name);

    @Query(value = "select * from product_image where product_id = ? and is_deleted = false", nativeQuery = true)
    List<Product_Image> findByIDProduct(long id_sanPham);

    @Query(value = "select * from product_image where product_id = ?1 and image_default = true;", nativeQuery = true)
    Product_Image findAnhMacDinh(long id_sp);

    @Modifying
    @Query(value = "delete from product_image where id = ?", nativeQuery = true)
    void xoaAnh(long id);

    @Query(value = "select name from product_image where product_id = ? and image_default = true limit 1", nativeQuery = true)
    String getTenAnhSanPham_HienThiDanhSach(long sanPham_id);

    @Query(value = "select name from product_image where product_id = ?1 and image_default = true limit 1", nativeQuery = true)
    String getAnhMacDinh(long san_pham_id, long mau_sac_id);

    @Query(value = "select name from product_image where product_id = ?1  and image_default = true", nativeQuery = true)
    String getAnhSPByMauSacAndSPID(long sanPham_id);

    @Query(value = "select * from product_image where product_id = ?", nativeQuery = true)
    List<Product_Image> getHinhAnhByProductID(long sanPham_id);

    @Query(value = "select * from product_image where product_id = ?1", nativeQuery = true)
    List<Product_Image> getHinhAnhs(long sanPham_id);
}
