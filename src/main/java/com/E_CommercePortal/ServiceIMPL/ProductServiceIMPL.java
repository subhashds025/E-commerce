package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Categories;
import com.E_CommercePortal.Entity.Product;
import com.E_CommercePortal.Repository.CategoriesRepository;
import com.E_CommercePortal.Repository.ProductRepository;
import com.E_CommercePortal.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceIMPL implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Product addProduct(Product product, int categoryId) {

        Optional<Categories> opCategory = categoriesRepository.findById(categoryId);
        if(opCategory.isPresent()){
            Categories categories = opCategory.get();
            product.setCategories(categories);
        }else{
            throw new RuntimeException("not such category");
        }
        return productRepository.save(product);
    }

    @Override
    public Product getPoduct(int id) {
        Optional<Product> opProduct = productRepository.findById(id);
        if (opProduct.isPresent()) {
            Product product = opProduct.get();
            return product;
        } else {
            throw new RuntimeException("product not found");

        }
    }
}
