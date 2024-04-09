package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.presentation.Request.Dto.OrderDto;

public interface OrderService {
  Order createOrder(OrderDto orderDto);
}
