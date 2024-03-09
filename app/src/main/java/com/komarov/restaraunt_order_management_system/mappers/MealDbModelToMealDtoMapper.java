package com.komarov.restaraunt_order_management_system.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MealDbModelToMealDtoMapper {

    com.komarov.restaraunt_order_management_system.api.dto.Meal map(com.komarov.restaraunt_order_management_system.data.Meal mealDbModel);
}
