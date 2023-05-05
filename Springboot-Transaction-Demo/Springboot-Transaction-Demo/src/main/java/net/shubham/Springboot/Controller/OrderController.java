package net.shubham.Springboot.Controller;

import net.shubham.Springboot.Dto.OrderRequest;
import net.shubham.Springboot.Dto.OrderResponse;
import net.shubham.Springboot.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> palceOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}

/*
{
    "order" : {
        "totalQuantity" : 3,
        "shoppingCartId" : 2,
        "totalPrice" : 20000
    },
    "payment" : {
        "type" : "DEBIT",
        "cardName":"Shubham Sawant",
        "cardNumber" : "1234 1234 1234",
        "expiryMonth": 2,
        "expiryDate": 2025,
        "cvc": 123
    }
}
 */