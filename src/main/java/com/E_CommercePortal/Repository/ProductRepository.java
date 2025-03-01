package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}