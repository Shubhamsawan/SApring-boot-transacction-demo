package net.shubham.Springboot.Dto;


import lombok.Getter;
import lombok.Setter;
import net.shubham.Springboot.Entity.Order;
import net.shubham.Springboot.Entity.Payment;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
