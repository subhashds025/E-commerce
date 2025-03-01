package com.E_CommercePortal.Service;

import com.E_CommercePortal.Entity.Product;

public interface ProductService {
    public Product addProduct(Product product,int categoryId);
    public  Product getPoduct(int id);
}
