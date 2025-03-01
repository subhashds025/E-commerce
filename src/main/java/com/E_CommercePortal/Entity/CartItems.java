package com.E_CommercePortal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_items")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="discount")
    private Double discount;

    @Column(name="product_price",nullable = false)
    private Double productPrice;

    @Column(name="quantity",nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

   public CartItems(){

   }
    public CartItems(Integer id, Double discount, Double productPrice, int quantity, Cart cart, Product product) {
        this.id = id;
        this.discount = discount;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }
}