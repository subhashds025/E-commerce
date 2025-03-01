package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}