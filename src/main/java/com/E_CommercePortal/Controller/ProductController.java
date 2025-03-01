package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Product;
import com.E_CommercePortal.ServiceIMPL.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductServiceIMPL productServiceIMPL;


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product,
                                              @RequestParam int categoryId){
        Product saved = productServiceIMPL.addProduct(product, categoryId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Product> getProduct(@RequestParam int id){
        Product product = productServiceIMPL.getPoduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
