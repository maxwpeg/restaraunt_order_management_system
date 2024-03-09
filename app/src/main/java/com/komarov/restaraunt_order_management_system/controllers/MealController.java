package com.komarov.restaraunt_order_management_system.controllers;

import com.komarov.restaraunt_order_management_system.api.dto.Meal;
import com.komarov.restaraunt_order_management_system.services.MealService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping(path = "/menu")
public class MealController {

    private final MealService mealService;

    @GetMapping
    public String showMenu(Model model) {
        model.addAttribute("meals", mealService.listMeals());
        return "meals";
    }

    @GetMapping(path = "/show/{id}")
    public String meal(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("meal", mealService.getById(id));
        return "meal";
    }

    @PostMapping("/update/{id}")
    public String editMeal(@PathVariable("id") UUID id, @RequestParam int hours, @RequestParam int minutes, @RequestParam int seconds, @RequestParam int amount, @RequestParam int price) {
        LocalTime prepTime = LocalTime.of(hours, minutes, seconds);
        mealService.setById(id, amount, price, prepTime);
        return "redirect:/menu";
    }

    @PostMapping("/create")
    public String createMeal(@RequestParam String name, @RequestParam int hours, @RequestParam int minutes, @RequestParam int seconds, @RequestParam int amount, @RequestParam int price) {
        LocalTime prepTime = LocalTime.of(hours, minutes, seconds);
        Meal meal = new Meal(UUID.randomUUID(), name, prepTime, price, amount);
        mealService.saveMeal(meal);
        return "redirect:/menu";
    }

    @PostMapping("/delete/{id}")
    public String deleteMeal(@PathVariable("id") UUID id) {
        mealService.deleteMeal(id);
        return "redirect:/menu";
    }

    @PostMapping("/edit-price/{id}/{newPrice}")
    public String editPrice(@PathVariable("id") UUID id, @PathVariable("newPrice") int newPrice) {
        mealService.editPrice(id, newPrice);
        return "redirect:/menu";
    }

}


