package com.komarov.restaraunt_order_management_system.data.repositories;

import com.komarov.restaraunt_order_management_system.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
