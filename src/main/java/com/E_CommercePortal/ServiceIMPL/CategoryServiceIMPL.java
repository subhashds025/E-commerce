package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Categories;
import com.E_CommercePortal.Repository.CategoriesRepository;
import com.E_CommercePortal.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceIMPL implements CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories addCategory(Categories categories) {
        return categoriesRepository.save(categories);
    }
}
