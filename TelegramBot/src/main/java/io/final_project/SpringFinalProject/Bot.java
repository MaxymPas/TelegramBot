package io.final_project.SpringFinalProject;


import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


public class Bot extends AbilityBot {

    public Bot() {
        super(//tokenBot, //tagBot);
    }

    public static SendMessage buyEvent(long сhatId, String call_data) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowDrinks = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Вернутися в меню");
        button.setCallbackData("drinks");
        rowDrinks.add(button);
        rowsInline.add(rowDrinks);
        markupInline.setKeyboard(rowsInline);

        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Ваша готівка: " + DrinksObject.money(call_data));
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendMessage sendMenu(long сhatId) {
        //Markup Keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        //
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowDrinks = new ArrayList<>();
        List<InlineKeyboardButton> rowMoney = new ArrayList<>();


        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Напої");
        button1.setCallbackData("drinks");
        rowDrinks.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Коктейлі");
        button2.setCallbackData("cocktails");
        rowDrinks.add(button2);


        InlineKeyboardButton button3 = new InlineKeyboardButton();

        button3.setText("Баланс");
        button3.setCallbackData("money");
        rowMoney.add(button3);


        // Set the keyboard to the markup
        rowsInline.add(rowDrinks);
        rowsInline.add(rowMoney);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Привіт.Бажаєте щось замовити?");
        message.setReplyMarkup(markupInline);
        return message;
    }

    public static SendMessage listCocktails(long сhatId) {


        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Ви вибрали коктейлі:");
        message.setReplyMarkup(DrinksObject.forMapCocktails(DrinksObject.listObjectCocktails()));
        return message;


    }

    public static SendMessage listDrinks(long сhatId) {

        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Ви вибрали безалкогольні напої:");
        message.setReplyMarkup(DrinksObject.forMap(DrinksObject.listObjectDrinks()));
        return message;


    }

    public static SendMessage sortByNameDrinks(long сhatId) {


        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Cортування за ціною");
        message.setReplyMarkup(DrinksObject.sortByNameDrinks(DrinksObject.listObjectDrinks()));
        return message;
    }

    public static SendMessage sortByPriceDrinks(long сhatId) {


        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Cортування за іменем");
        message.setReplyMarkup(DrinksObject.sortByPriceDrinks(DrinksObject.listObjectDrinks()));
        return message;
    }

    public static SendMessage sortByNameCocktails(long сhatId) {


        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Cортування за ціною");
        message.setReplyMarkup(DrinksObject.sortByNameCocktails(DrinksObject.listObjectCocktails()));
        return message;
    }

    public static SendMessage sortByPriceCocktails(long сhatId) {


        SendMessage message = new SendMessage();
        message.setChatId(сhatId);
        message.setText("Cортування за іменем");
        message.setReplyMarkup(DrinksObject.sortByPriceCocktails(DrinksObject.listObjectCocktails()));
        return message;
    }

    @Override
    public long creatorId() {
        return 123456789;
    }

    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                long chat_idDB = update.getMessage().getChatId();
                if (update.getMessage().getText().equals("/start")) {

                    try {
                        execute(sendMenu(chat_idDB));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();


            if (call_data.equals("drinks")) {

                try {

                    execute(listDrinks(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (call_data.equals("cocktails")) {
                try {
                    execute(listCocktails(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (call_data.equals("money")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Ваш баланс:" + DrinksObject.money);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("execute0")) {


                try {
                    execute(sortByNameDrinks(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("execute1")) {


                try {
                    execute(sortByPriceDrinks(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("executeC0")) {


                try {
                    execute(sortByNameCocktails(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("executeC1")) {


                try {
                    execute(sortByPriceCocktails(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("execute2") || call_data.equals("executeC2")) {
                try {
                    execute(sendMenu(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (call_data.equals("Чай")) {
                try {
                    execute(DrinksInfo.tea(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("Лимонад")) {
                try {
                    execute(DrinksInfo.lemonade(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("Вода")) {
                try {
                    execute(DrinksInfo.water(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("Кола")) {
                try {

                    execute(DrinksInfo.cola(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("Узвар")) {

                try {

                    execute(DrinksInfo.compote(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("back")) {
                try {
                    execute(listDrinks(chat_id));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("buyTea")) {
                try {


                    execute(buyEvent(chat_id, call_data));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("buyLemonade")) {
                try {


                    execute(buyEvent(chat_id, call_data));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("buyWater")) {
                try {


                    execute(buyEvent(chat_id, call_data));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("buyCola")) {
                try {


                    execute(buyEvent(chat_id, call_data));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (call_data.equals("buyCompote")) {
                try {


                    execute(buyEvent(chat_id, call_data));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }

        }


    }


}

