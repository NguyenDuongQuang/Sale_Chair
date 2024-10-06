package com.example.backend.repository.cart;

import com.example.backend.entity.cart.Cart_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<Cart_Detail,Long> {
}
