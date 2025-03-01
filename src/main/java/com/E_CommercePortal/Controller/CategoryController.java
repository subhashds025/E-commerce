package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Categories;
import com.E_CommercePortal.ServiceIMPL.CategoryServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryServiceIMPL categoryServiceIMPL;

    @PostMapping
    public ResponseEntity<Categories>  addCategory(@RequestBody Categories categories){
        Categories saved = categoryServiceIMPL.addCategory(categories);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
