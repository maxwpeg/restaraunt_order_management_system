package com.komarov.restaraunt_order_management_system.services;

import com.komarov.restaraunt_order_management_system.api.dto.Order;
import com.komarov.restaraunt_order_management_system.data.repositories.OrderRepository;
import com.komarov.restaraunt_order_management_system.mappers.OrderDbModelToOrderDtoMapper;
import com.komarov.restaraunt_order_management_system.mappers.OrderDtoToOrderDbModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDbModelToOrderDtoMapper orderDbModelToOrderDtoMapper;

    private final OrderDtoToOrderDbModelMapper orderDtoToOrderDbModelMapper;

    private final OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(orderDtoToOrderDbModelMapper.map(order));
    }

}