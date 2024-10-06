package com.example.backend.repository.user;

import com.example.backend.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "select * from address where customer_id = ? and address_default = true", nativeQuery = true)
    Address getAddress(long customer_id);
}
