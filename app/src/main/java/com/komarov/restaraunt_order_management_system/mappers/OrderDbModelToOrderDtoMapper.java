package com.komarov.restaraunt_order_management_system.mappers;

import com.komarov.restaraunt_order_management_system.api.dto.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface OrderDbModelToOrderDtoMapper {
    Order map(com.komarov.restaraunt_order_management_system.data.Order order);
}
