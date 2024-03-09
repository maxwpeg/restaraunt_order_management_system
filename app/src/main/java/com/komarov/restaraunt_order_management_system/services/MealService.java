package com.komarov.restaraunt_order_management_system.services;

import com.komarov.restaraunt_order_management_system.api.dto.Meal;
import com.komarov.restaraunt_order_management_system.data.repositories.MealRepository;
import com.komarov.restaraunt_order_management_system.mappers.MealDbModelToMealDtoMapper;
import com.komarov.restaraunt_order_management_system.mappers.MealDtoToMealDbModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MealService {

    private final MealDbModelToMealDtoMapper mealDbModelToMealDtoMapper;

    private final MealDtoToMealDbModelMapper mealDtoToMealDbModelMapper;

    private final MealRepository mealRepository;

    public List<Meal> listMeals() {
        return mealRepository.findAll()
                .stream()
                .map(mealDbModelToMealDtoMapper::map)
                .collect(Collectors.toList());
    }

    public void saveMeal(Meal meal) {
        mealRepository.save(mealDtoToMealDbModelMapper.map(meal));
    }

    public void deleteMeal(UUID id) {
        mealRepository.deleteById(id);
    }

    public void editPrice(UUID id, int newPrice) {
        com.komarov.restaraunt_order_management_system.data.Meal meal = mealRepository.getReferenceById(id);
        meal.setPrice(newPrice);
    }

    public Meal getById(UUID id) {
        return mealDbModelToMealDtoMapper.map(mealRepository.getReferenceById(id));
    }

    public void setById(UUID id, int amount, int price, LocalTime prepTime) {
        com.komarov.restaraunt_order_management_system.data.Meal meal = mealRepository.getReferenceById(id);
        meal.setAmount(amount);
        meal.setPrice(price);
        meal.setPrepTime(prepTime);
        mealRepository.save(meal);
    }

//    public void editTime(UUID id, )
}
