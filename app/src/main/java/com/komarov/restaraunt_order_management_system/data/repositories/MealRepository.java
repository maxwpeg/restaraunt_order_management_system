package com.komarov.restaraunt_order_management_system.data.repositories;

import com.komarov.restaraunt_order_management_system.data.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {
}
