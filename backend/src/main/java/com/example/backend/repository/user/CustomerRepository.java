package com.example.backend.repository.user;

import com.example.backend.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer where email = ?", nativeQuery = true)
    Customer findByEmail(String email);


    @Query(value = "select * from customer is_deleted = false order by id desc", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer where id = ? and is_deleted = false", nativeQuery = true)
    Customer findByID(Long id);

    @Query(value = "select * from customer where name = ?", nativeQuery = true)
    Optional<Customer> findByName(String name);


    @Query(value = "select * from customer where name = ?1 OR phone = ?1 OR email = ?1 OR address = ?1", nativeQuery = true)
    List<Customer> findCustomerAll(String input);

    @Query(value = "select * from customer where is_deleted = false and date(birth_day) = ?", nativeQuery = true)
    List<Customer> findCustomerDate(LocalDate ngaySinh);

    @Query(value = "select * from customer where phone  = ?", nativeQuery = true)
    Customer findByPhone(String so_dien_thoai);


}
