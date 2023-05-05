package net.shubham.Springboot.Repository;

import net.shubham.Springboot.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
