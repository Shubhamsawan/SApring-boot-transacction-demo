package net.shubham.Springboot.Repository;

import net.shubham.Springboot.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
