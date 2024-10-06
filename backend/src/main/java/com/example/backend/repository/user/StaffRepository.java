package com.example.backend.repository.user;

import com.example.backend.entity.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    @Query(value = "select * from staff where email = ?", nativeQuery = true)
    Staff findByEmail(String username);
}
