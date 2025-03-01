package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Order;
import com.E_CommercePortal.Entity.OrderItems;
import com.E_CommercePortal.Entity.Product;
import com.E_CommercePortal.Repository.OrderItemsRepository;
import com.E_CommercePortal.Repository.OrderRepository;
import com.E_CommercePortal.Repository.ProductRepository;
import com.E_CommercePortal.Service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemsServiceIMPL implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public OrderItems addOrderItems(OrderItems orderItems, int productId, int orderId) {

        Optional<Product> opProduct = productRepository.findById(productId);
        if(opProduct.isPresent()){
            Product product = opProduct.get();
            orderItems.setProduct(product);
        }else{
            throw new RuntimeException("there is no such product");
        }

        Optional<Order> opOrder = orderRepository.findById(orderId);
        if(opOrder.isPresent()){
            Order order = opOrder.get();
            orderItems.setOrder(order);
        }else{
            throw new RuntimeException("order not found");
        }
        return orderItemsRepository.save(orderItems);
    }
}
