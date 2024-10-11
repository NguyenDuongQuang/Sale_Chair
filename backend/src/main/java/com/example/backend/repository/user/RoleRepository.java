package com.example.backend.repository.user;

import com.example.backend.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select * from role where role_name = ?", nativeQuery = true)
    Role find(String role_name);

}
