package com.komarov.restaraunt_order_management_system.controllers;

import com.komarov.restaraunt_order_management_system.api.dto.Meal;
import com.komarov.restaraunt_order_management_system.api.dto.Order;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.komarov.restaraunt_order_management_system.services.OrderService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/orders")
@AllArgsConstructor
public class OrderController {

  private final OrderService orderService;
  @PostMapping("/create")
  public String createMeal(Order order) {
    orderService.saveOrder(order);
    return "redirect:/orders";
  }

}
