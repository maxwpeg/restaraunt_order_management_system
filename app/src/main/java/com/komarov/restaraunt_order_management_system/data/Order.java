package com.komarov.restaraunt_order_management_system.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Order {

    private UUID id;

    private LocalTime startTime;

    private List<Meal> meals;

    private UUID clientId;
}
