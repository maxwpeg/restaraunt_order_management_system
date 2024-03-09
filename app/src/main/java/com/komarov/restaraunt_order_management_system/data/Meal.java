package com.komarov.restaraunt_order_management_system.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "prep_time")
    private LocalTime prepTime;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

}
