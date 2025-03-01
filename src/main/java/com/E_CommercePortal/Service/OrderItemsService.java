package com.E_CommercePortal.Service;

import com.E_CommercePortal.Entity.OrderItems;

public interface OrderItemsService {
    public OrderItems addOrderItems(OrderItems orderItems,int productId,int orderId);
}
