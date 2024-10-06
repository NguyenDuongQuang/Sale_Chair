package com.example.backend.repository.bill;

import com.example.backend.entity.bill.Bill_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bill_DetailRepository extends JpaRepository<Bill_Detail,Long> {
}
