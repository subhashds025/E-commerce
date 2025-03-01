package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Order;
import com.E_CommercePortal.Entity.OrderItems;
import com.E_CommercePortal.Entity.Payment;
import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Repository.OrderItemsRepository;
import com.E_CommercePortal.Repository.OrderRepository;
import com.E_CommercePortal.Repository.PaymentRepository;
import com.E_CommercePortal.Repository.UsersRepository;
import com.E_CommercePortal.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository; // Injecting OrderItemsRepository to access OrderItems data.

    @Override
    public Order addOrder(Order order, int paymentId, int userId) {
        Optional<Users> opUser = usersRepository.findById(userId);
        if(opUser.isPresent()){
            Users user = opUser.get();
            order.setUser(user);
        } else {
            throw new RuntimeException("User not found");
        }

        Optional<Payment> opPayment = paymentRepository.findById(paymentId);
        if(opPayment.isPresent()){
            Payment payment = opPayment.get();
            order.setPayment(payment);
        } else {
            throw new RuntimeException("Payment method not found");
        }

        // Calculate total price for the order based on the OrderItems
        double totalAmount = calculateTotalAmount(order);

        // Set the calculated totalAmount for the order
        order.setTotalAmount(totalAmount);

        // Save the order with the total amount
        return orderRepository.save(order);
    }

    // Method to calculate the total amount of the order
    private double calculateTotalAmount(Order order) {
        double totalAmount = 0.0;

        // Assuming each order has orderItems, iterate over them and calculate the price
        for (OrderItems orderItem : order.getOrderItems()) {
            double productPrice = orderItem.getOrderedProductPrice();
            int quantity = orderItem.getQuantity();
            double discount = orderItem.getDiscount() != null ? orderItem.getDiscount() : 0.0;

            // Calculate price for this orderItem considering the discount
            double itemTotal = (productPrice - discount) * quantity;

            // Add this item's total to the overall total amount
            totalAmount += itemTotal;
        }

        return totalAmount;
    }
}
