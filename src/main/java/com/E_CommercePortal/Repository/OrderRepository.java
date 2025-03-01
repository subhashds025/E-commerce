package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}