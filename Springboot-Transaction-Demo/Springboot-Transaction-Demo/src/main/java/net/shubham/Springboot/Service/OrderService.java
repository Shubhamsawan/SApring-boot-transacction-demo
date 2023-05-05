package net.shubham.Springboot.Service;

import net.shubham.Springboot.Dto.OrderRequest;
import net.shubham.Springboot.Dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
