package io.final_project.SpringFinalProject;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

public class DrinksObject {
    public static int money = 100;
    public static Drinks tea = new Drinks("Чай", "Зелений", 15);
    public static Drinks lemonade = new Drinks("Лимонад", "Жовтий", 27);
    public static Drinks water = new Drinks("Вода", "Прозорий", 0);
    public static Drinks cola = new Drinks("Кола", "Чорний", 41);
    public static Drinks compote = new Drinks("Узвар", "Червоний", 33);


    public static Cocktails mojito = new Cocktails("Мохіто", "зелений", 77, 14);
    public static Cocktails margarita = new Cocktails("Маргарита", "білий", 112, 17);
    public static Cocktails martini = new Cocktails("Мартіні", "Білий", 83, 27.5F);
    public static Cocktails daiquiri = new Cocktails("Дайкірі", "Прозорий", 97, 16.5F);
    public static Cocktails pinaColada = new Cocktails("ПінаКолада", "Кремовий", 92, 18);

    public static Map<String, Integer> listObjectDrinks() {
        Map<String, Integer> mapDrinks = new LinkedHashMap<>();
        mapDrinks.put(tea.name, tea.price);
        mapDrinks.put(lemonade.name, lemonade.price);
        mapDrinks.put(water.name, water.price);
        mapDrinks.put(cola.name, cola.price);
        mapDrinks.put(compote.name, compote.price);
        return mapDrinks;
    }

    public static Map<String, Integer> listObjectCocktails() {
        Map<String, Integer> mapCocktails = new LinkedHashMap<>();
        mapCocktails.put(mojito.name, mojito.price);
        mapCocktails.put(margarita.name, margarita.price);
        mapCocktails.put(martini.name, martini.price);
        mapCocktails.put(daiquiri.name, daiquiri.price);
        mapCocktails.put(pinaColada.name, pinaColada.price);
        return mapCocktails;
    }

    public static InlineKeyboardMarkup sortByNameDrinks(Map<String, Integer> mapDrinks) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mapDrinks.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        return forList(entryList);
        //    forList(entryList);
    }

    public static InlineKeyboardMarkup sortByPriceDrinks(Map<String, Integer> mapDrinks) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(mapDrinks);
        forMap(sortedMap);
        return forMap(sortedMap);
    }

    public static InlineKeyboardMarkup sortByNameCocktails(Map<String, Integer> mapDrinks) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mapDrinks.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        return forListCocktails(entryList);
        //    forList(entryList);
    }

    public static InlineKeyboardMarkup sortByPriceCocktails(Map<String, Integer> mapDrinks) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(mapDrinks);
        forMap(sortedMap);
        return forMapCocktails(sortedMap);
    }

    public static InlineKeyboardMarkup forMap(Map<String, Integer> mapAllDrinks) {

        String[] arr = {"Cорт. ціна", "Сорт. A-Я", "Назад"};
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapAllDrinks.entrySet()) {
            //for (int i = 0; i < mapDrinks.size() ; i++) {
            List<InlineKeyboardButton> buttonRow = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(entry.getKey() + " " + entry.getValue());
            button.setCallbackData(entry.getKey());
            buttonRow.add(button);
            rowsInline.add(buttonRow);
        }
        List<InlineKeyboardButton> buttonRow = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 2) {
                buttonRow = new ArrayList<>();
                rowsInline.add(buttonRow);
            }
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(arr[i]);
            button.setCallbackData("execute" + i);
            buttonRow.add(button);


        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    public static InlineKeyboardMarkup forList(List<Map.Entry<String, Integer>> entryList) {

        String[] arr = {"Cорт. ціна", "Сорт. A-Я", "Назад"};
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            //for (int i = 0; i < mapDrinks.size() ; i++) {
            List<InlineKeyboardButton> buttonRow = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(entry.getKey() + " " + entry.getValue());
            button.setCallbackData(entry.getKey());
            buttonRow.add(button);
            rowsInline.add(buttonRow);
        }
        List<InlineKeyboardButton> buttonRow = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 2) {
                buttonRow = new ArrayList<>();
                rowsInline.add(buttonRow);
            }
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(arr[i]);
            button.setCallbackData("execute" + i);
            buttonRow.add(button);


        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }


    public static InlineKeyboardMarkup forMapCocktails(Map<String, Integer> mapAllDrinks) {

        String[] arr = {"Cорт. ціна", "Сорт. A-Я", "Назад"};
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapAllDrinks.entrySet()) {
            //for (int i = 0; i < mapDrinks.size() ; i++) {
            List<InlineKeyboardButton> buttonRow = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(entry.getKey() + " " + entry.getValue());
            button.setCallbackData(entry.getKey());
            buttonRow.add(button);
            rowsInline.add(buttonRow);
        }
        List<InlineKeyboardButton> buttonRow = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 2) {
                buttonRow = new ArrayList<>();
                rowsInline.add(buttonRow);
            }
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(arr[i]);
            button.setCallbackData("executeC" + i);
            buttonRow.add(button);


        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    public static InlineKeyboardMarkup forListCocktails(List<Map.Entry<String, Integer>> entryList) {

        String[] arr = {"Cорт. ціна", "Сорт. A-Я", "Назад"};
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            //for (int i = 0; i < mapDrinks.size() ; i++) {
            List<InlineKeyboardButton> buttonRow = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(entry.getKey() + " " + entry.getValue());
            button.setCallbackData(entry.getKey());
            buttonRow.add(button);
            rowsInline.add(buttonRow);
        }
        List<InlineKeyboardButton> buttonRow = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 2) {
                buttonRow = new ArrayList<>();
                rowsInline.add(buttonRow);
            }
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(arr[i]);
            button.setCallbackData("executeC" + i);
            buttonRow.add(button);


        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    public static int money(String call_data) {

        if (call_data.equals("buyTea")) {
            return money -= tea.price;
        } else if (call_data.equals("buyLemonade")) {
            return money -= lemonade.price;

        } else if (call_data.equals("buyCola")) {
            return money -= cola.price;
        } else if (call_data.equals("buyWater")) {
            return money -= water.price;
        } else if (call_data.equals("buyCompote")) {
            return money -= compote.price;
        } else {
            return money;
        }
    }
}
