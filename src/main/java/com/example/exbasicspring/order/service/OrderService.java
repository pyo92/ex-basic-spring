package com.example.exbasicspring.order.service;

import com.example.exbasicspring.order.domain.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
