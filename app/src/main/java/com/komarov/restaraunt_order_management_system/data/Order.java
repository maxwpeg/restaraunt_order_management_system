package com.komarov.restaraunt_order_management_system.data;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "start_time")
    private LocalTime startTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_meal", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals;

    @Column(name = "client_name")
    private String clientName;
}
