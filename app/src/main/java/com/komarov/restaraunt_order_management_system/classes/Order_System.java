//package com.komarov.restaraunt_order_management_system.classes;
//
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Scanner;
//import org.springframework.cglib.core.Local;
//
//public class Order_System {
//
//    private ArrayList<Administrator> _administrators;
//
//    private User _currentUser;
//
//    private Menu _menu = new Menu(Map.of());
//
//    private boolean retry(String message) {
//        int answer;
//        while (true) {
//            System.out.println(message + " Повторить попытку(1) или отменить аутентификацию(2)?");
//            Scanner scanner = new Scanner(System.in);
//            try {
//                answer = scanner.nextInt();
//            } catch (Exception e) {
//                System.out.println("Неверный ввод, повторите попытку.");
//                continue;
//            }
//            if (answer == 1) {
//                return true;
//            }
//            if (answer == 2) {
//                return false;
//            }
//            System.out.println("Неверный ввод, повторите попытку.");
//        }
//    }
//
//    private int getInt(String var) {
//        int answer;
//        while (true) {
//            System.out.println("Введите: " + var + " в формате целого числа(int): ");
//            Scanner scanner = new Scanner(System.in);
//            try {
//                answer = scanner.nextInt();
//                return answer;
//            } catch (Exception e) {
//                System.out.println("Неверный ввод, повторите попытку.");
//            }
//        }
//    }
//
//    private LocalTime getMinutes() {
//        int input;
//        while (true) {
//            input = getInt("количество минут");
//            if (input > 0 && input < 1439) {
//                break;
//            }
//            System.out.println("Число минут может быть только в интервале [0, 1439].");
//            System.out.println("Повторите попытку.");
//        }
//      return LocalTime.of(input / 60, input % 60);
//    }
//
//    private boolean hasLogin(String login) {
//        for (Administrator admin : _administrators) {
//            if (admin.get_name().equals(login)) {
//               return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean checkPassword(String login, String password) {
//        for (Administrator admin : _administrators) {
//            if (admin.get_name().equals(login) && admin.get_password().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean registerAdministrator(String login) {
//        String password = getLine("новый пароль");
//        while (true) {
//            String passwordConfirm = getLine("новый пароль повторно");
//            if (!passwordConfirm.equals(password)) {
//                if (!retry("Введенные пароли не совпадают.")) {
//                    System.out.println("Регистрация отменена");
//                    return false;
//                }
//                continue;
//            }
//            System.out.println("Пароль успешно установлен.");
//            break;
//        }
//        Administrator newAdmin = new Administrator(login, password);
//        _administrators.add(newAdmin);
//        System.out.println("Администратор успешно зарегистрирован.");
//        return true;
//    }
//
//    private String getLine(String var) {
//        String res;
//        while (true) {
//            System.out.println("Введите: " + var + ": ");
//            Scanner in = new Scanner(System.in);
//            res = in.nextLine();
//            if (!res.isEmpty()) {
//                System.out.println(var + "успешно установлен");
//                break;
//            }
//            if (!retry(var + "не может быть пустым.")) {
//                System.out.println("Отмена операции...");
//                break;
//            }
//        }
//        return res;
//    }
//
//    public boolean authenticateAdministrator() {
//        System.out.println("Запущен процесс аутентификации администратора...");
//        while (true) {
//            String name = getLine("логин администратора");
//            if (hasLogin(name)) {
//                while (true) {
//                    String password = getLine("пароль");
//                    if (checkPassword(name, password)) {
//                        System.out.println("Успешная аутентификация.");
//                        _currentUser = new Administrator(name, password);
//                        return true;
//                    }
//                    if (!retry("Неверный пароль.")) {
//                        System.out.println("Аутентификация отменена.");
//                        return false;
//                    }
//                }
//            }
//            if (!retry("Администратор с таким логином не зарегистрирован.")) {
//                System.out.println("Аутентификация отменена.");
//                return false;
//            }
//        }
//    }
//
//    public void authenticateClient() {
//        System.out.println("Добрый день!");
//        String name = getLine("ваше имя для продолжения");
//        _currentUser = new User(name);
//    }
//
//    public void addMeal() {
//        String mealName = getLine("название нового блюда");
//        LocalTime minutes = getMinutes();
//        int price = getInt("цену в рублях");
//        Meal meal = new Meal(mealName, minutes, price);
//        int count = getInt("количество");
//        _menu.addMeal(meal, count);
//    }
//
//    public void removeMeal() {
//        String mealName = getLine("название блюда для удаления");
//        for (Meal meal : _menu.get_meals().keySet()) {
//            if (Objects.equals(meal.get_name(), mealName)) {
//                _menu.removeMeal(meal);
//                return;
//            }
//        }
//        System.out.println("Такого блюда в меню нет.");
//    }
//
//    public void editCount() {
//        String mealName = getLine("название блюда для изменения количества");
//        for (Meal meal : _menu.get_meals().keySet()) {
//            if (Objects.equals(meal.get_name(), mealName)) {
//                int count = getInt("новое количество блюда");
//                _menu.editCount(meal, count);
//                return;
//            }
//        }
//        System.out.println("Такого блюда в меню нет.");
//    }
//
//    public void editCookingTime() {
//        String mealName = getLine("название блюда для изменения времени приготовления");
//        for (Meal meal : _menu.get_meals().keySet()) {
//            if (Objects.equals(meal.get_name(), mealName)) {
//                LocalTime cookingTime = getMinutes();
//                int price = meal.get_price();
//                int count = _menu.get_meals().get(meal);
//                Meal editedMeal = new Meal(mealName, cookingTime, price);
//                _menu.removeMeal(meal);
//                _menu.addMeal(editedMeal, count);
//                return;
//            }
//        }
//        System.out.println("Такого блюда в меню нет.");
//    }
//
//    public void editPrice() {
//        String mealName = getLine("название блюда для изменения цены");
//        for (Meal meal : _menu.get_meals().keySet()) {
//            if (Objects.equals(meal.get_name(), mealName)) {
//                LocalTime cookingTime = meal.get_cookingTime();
//                int price = getInt("новую цену для блюда в рублях");
//                int count = _menu.get_meals().get(meal);
//                Meal editedMeal = new Meal(mealName, cookingTime, price);
//                _menu.removeMeal(meal);
//                _menu.addMeal(editedMeal, count);
//                return;
//            }
//        }
//        System.out.println("Такого блюда в меню нет.");
//    }
//
//}
