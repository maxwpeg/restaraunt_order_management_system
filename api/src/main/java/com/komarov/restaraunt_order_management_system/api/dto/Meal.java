package com.komarov.restaraunt_order_management_system.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Meal {

    private UUID id;

    private String name;

    private LocalTime prepTime;

    private int price;

    private int amount;

}
