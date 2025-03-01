package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Order;
import com.E_CommercePortal.ServiceIMPL.OrderServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderServiceIMPL orderServiceIMPL;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order,
                                          @RequestParam int paymentId,
                                          @RequestParam int userId){
        Order savedOrder = orderServiceIMPL.addOrder(order,paymentId,userId);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}

