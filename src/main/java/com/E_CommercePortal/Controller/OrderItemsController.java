package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.OrderItems;
import com.E_CommercePortal.ServiceIMPL.OrderItemsServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/oderitem")
public class OrderItemsController {

    @Autowired
    private OrderItemsServiceIMPL orderItemsServiceIMPL;

    @PostMapping
    public ResponseEntity<OrderItems> addOrderItems(@RequestBody OrderItems orderItems,
                                                    @RequestParam int productId,
                                                    @RequestParam int orderId){
        OrderItems saved = orderItemsServiceIMPL.addOrderItems(orderItems, productId, orderId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
