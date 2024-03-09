package com.komarov.restaraunt_order_management_system.controllers;

import com.komarov.restaraunt_order_management_system.classes.Order;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {

  @GetMapping
  @ResponseBody
  public String getOrders() {
    return "orders";
  }

}
