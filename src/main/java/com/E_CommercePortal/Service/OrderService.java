package com.E_CommercePortal.Service;

import com.E_CommercePortal.Entity.Order;

public interface OrderService {
    public Order addOrder(Order order,int paymnetId,int userId);
}
