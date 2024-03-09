//package com.komarov.restaraunt_order_management_system.classes;
//
//import java.time.LocalTime;
//import lombok.Builder;
//import lombok.Data;
//
//import java.util.Map;
//
//@Data
//@Builder
//public class Menu {
//
//    private Map<Meal, Integer> _meals;
//
//    public void addMeal(Meal meal, Integer count) {
//        _meals.put(meal, count);
//        String message = """
//                Блюдо %s в количестве %d успешно добавлено в меню.""";
//        System.out.printf((message) + "%n", meal, count);
//    }
//
//    public void removeMeal(Meal meal) {
//        _meals.remove(meal);
//        String message = """
//                Блюдо %s успешно удалено из меню.""";
//        System.out.printf((message) + "%n", meal);
//    }
//
//    public void editCount(Meal meal, int newCount) {
//        int prevCount = _meals.get(meal);
//        _meals.replace(meal, newCount);
//        if (prevCount != newCount + 1) {
//            String message = """
//                Блюду %s успешно установлено количество %d.""";
//            System.out.printf((message) + "%n", meal, newCount);
//        }
//    }
//
//}
