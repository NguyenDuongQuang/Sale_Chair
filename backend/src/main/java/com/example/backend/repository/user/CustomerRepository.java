package com.example.backend.repository.user;

import com.example.backend.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer where email = ?", nativeQuery = true)
    Customer findByEmail(String email);
}
