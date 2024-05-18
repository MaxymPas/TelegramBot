package io.final_project.SpringFinalProject;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class DrinksInfo extends DrinksObject {
    public static SendPhoto tea(long сhatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowMenu = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("back");
        rowMenu.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Купити");
        button2.setCallbackData("buyTea");
        rowMenu.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowMenu);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);


        SendPhoto message = new SendPhoto();
        //SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setCaption("Ви вибрали: " + tea.name +
                "\nЦіна: " + tea.price +
                "\nКолір: " + tea.color);
        message.setPhoto(new InputFile((new java.io.File("src/main/java/io/final_project/SpringFinalProject/img/tea.webp"))));
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendPhoto lemonade(long сhatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowMenu = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("back");
        rowMenu.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Купити");
        button2.setCallbackData("buyLemonade");
        rowMenu.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowMenu);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);


        SendPhoto message = new SendPhoto();
        //SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setCaption("Ви вибрали: " + lemonade.name +
                "\nЦіна: " + lemonade.price +
                "\nКолір: " + lemonade.color);
        message.setPhoto(new InputFile((new java.io.File("src/main/java/io/final_project/SpringFinalProject/img/lemonade.webp"))));
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendPhoto water(long сhatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowMenu = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("back");
        rowMenu.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Купити");
        button2.setCallbackData("buyWater");
        rowMenu.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowMenu);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);


        SendPhoto message = new SendPhoto();
        //SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setCaption("Ви вибрали: " + water.name +
                "\nЦіна: " + water.price +
                "\nКолір: " + water.color);
        message.setPhoto(new InputFile((new java.io.File("src/main/java/io/final_project/SpringFinalProject/img/water.jpg"))));
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendPhoto cola(long сhatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowMenu = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("backCola");
        rowMenu.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Купити");
        button2.setCallbackData("buy");
        rowMenu.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowMenu);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);


        SendPhoto message = new SendPhoto();
        message.setChatId(сhatId);
        message.setCaption("Ви вибрали: " + cola.name +
                "\nЦіна: " + cola.price +
                "\nКолір: " + cola.color);
        message.setPhoto(new InputFile((new java.io.File("src/main/java/io/final_project/SpringFinalProject/img/cola.jpg"))));
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendPhoto compote(long сhatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowMenu = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("back");
        rowMenu.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Купити");
        button2.setCallbackData("buyCompote");
        rowMenu.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowMenu);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);


        SendPhoto message = new SendPhoto();
        //SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setCaption("Ви вибрали: " + compote.name +
                "\nЦіна: " + compote.price +
                "\nКолір: " + compote.color);
        message.setPhoto(new InputFile(new java.io.File("src/main/java/io/final_project/SpringFinalProject/img/compote.webp")));
        message.setReplyMarkup(markupInline);
        return message;
    }


}
