package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Payment;
import com.E_CommercePortal.Repository.PaymentRepository;
import com.E_CommercePortal.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Payment addPayment(Payment payment) {
        return   paymentRepository.save(payment);
    }
}
