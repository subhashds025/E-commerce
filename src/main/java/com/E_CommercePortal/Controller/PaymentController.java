package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Payment;
import com.E_CommercePortal.ServiceIMPL.PaymentServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pay")
public class PaymentController {

    @Autowired
    private PaymentServiceIMPL paymentServiceIMPL;

    @PostMapping
    public ResponseEntity<Payment> addPay(@RequestBody Payment payment){
        Payment saved = paymentServiceIMPL.addPayment(payment);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
