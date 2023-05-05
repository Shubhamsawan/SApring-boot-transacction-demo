package net.shubham.Springboot.Service.Impl;

import net.shubham.Springboot.Dto.OrderRequest;
import net.shubham.Springboot.Dto.OrderResponse;
import net.shubham.Springboot.Entity.Order;
import net.shubham.Springboot.Entity.Payment;
import net.shubham.Springboot.Exception.PaymentException;
import net.shubham.Springboot.Repository.OrderRepository;
import net.shubham.Springboot.Repository.PaymentRepository;
import net.shubham.Springboot.Service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        // Save order details
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        //Save Payment Detail
        Payment payment = orderRequest.getPayment();
        //if payment fail
        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type does not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
