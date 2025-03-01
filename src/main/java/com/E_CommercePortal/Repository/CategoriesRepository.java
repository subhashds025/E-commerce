package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}