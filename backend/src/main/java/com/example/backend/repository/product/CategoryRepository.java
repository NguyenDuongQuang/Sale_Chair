package com.example.backend.repository.product;

import com.example.backend.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value="SELECT *FROM category ",nativeQuery = true)
    List<Category> findAll();

    @Query(value="SELECT * FROM category WHERE id=? and is_deleted=false",nativeQuery = true)
    Optional<Category> findById(Long id);

    @Query(value = "select * from category where id = ? and is_deleted = false", nativeQuery = true)
    Category findByID(Long id);

    @Query(value="SELECT * FROM category WHERE is_deleted=false AND DATE(started_date)=?",nativeQuery = true)
    List<Category> findByDate(LocalDate startedDate);

    @Query(value="SELECT *FROM category WHERE is_deleted=false AND name=? ORDER BY id DESC",nativeQuery = true)
    Category findByName(String name);

    @Query(value = "SELECT * FROM category WHERE is_deleted = false AND (name LIKE %?1% OR maximumvalue LIKE %?1% OR percent_discount LIKE %?1%)", nativeQuery = true)
    List<Category> findByAll(String input);


}
