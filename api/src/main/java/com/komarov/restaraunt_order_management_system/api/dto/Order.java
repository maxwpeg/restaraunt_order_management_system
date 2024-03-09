package com.komarov.restaraunt_order_management_system.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Order {

    private UUID id;

    private LocalTime startTime;

    private List<Meal> meals;

    private String clientName;

}
