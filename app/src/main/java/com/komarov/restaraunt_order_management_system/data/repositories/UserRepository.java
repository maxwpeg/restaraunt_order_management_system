package com.komarov.restaraunt_order_management_system.data.repositories;

import com.komarov.restaraunt_order_management_system.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByLogin(String login);
}
