package com.example.backend.repository.product;

import com.example.backend.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> findAll();

    @Query(value = "select * from product where id = ? and is_deleted = false", nativeQuery = true)
    Product findByID(Long id);

    @Query(value = "select * from product\n" +
            "where is_deleted = false and (name LIKE %?1% or gia LIKE %?1%) and status = 0;", nativeQuery = true)
    List<Product> findByAll(String input);

    @Query(value = "SELECT * FROM product WHERE is_deleted = false AND DATE(started_date) = ?", nativeQuery = true)
    List<Product> findByDate(LocalDate ngayTao);

    @Query(value = "SELECT * FROM product WHERE is_deleted = false AND name LIKE %?1% and status = 0", nativeQuery = true)
    List<Product> findByName(String name);

    @Query(value = "SELECT * FROM product WHERE is_deleted = false AND name = ? and status = 0;", nativeQuery = true)
    Product checkLap(String tenSP);

    @Query(value = "select * from product where category_id = ? and is_deleted = false and status = 0", nativeQuery = true)
    List<Product> findByCategory(long category_id);

    @Query(value = "SELECT * FROM product WHERE pricre BETWEEN :gia1 AND :gia2 AND is_deleted = false and status = 0", nativeQuery = true)
    List<Product> findTheoGia(@Param("gia1") Float gia1, @Param("gia2") Float gia2);
}
