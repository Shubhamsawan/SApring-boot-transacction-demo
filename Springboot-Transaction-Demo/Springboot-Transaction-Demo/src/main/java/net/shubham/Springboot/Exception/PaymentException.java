package net.shubham.Springboot.Exception;

public class PaymentException extends RuntimeException{

    public PaymentException(String message) {
        super(message);
    }
}
