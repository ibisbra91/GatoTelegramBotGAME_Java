package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "C4tb0t_Gam3_1b1s_bot";
    public static final String TOKEN = "6635129863:AAF3Ceac_1pIel61ktJ_bpwP1JsFHE2TZ_I";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }
/** DESCRIPTION: The void onUpdateEventReceived(Update u) method schedules the catbot's
 * reaction when a Telegram user writes a message to it or performs another action on it.*/
    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            sendTextMessageAsync("Hola, *soy Catbot* en _pañales_.");
        }
        if(getMessageText().contains("Hola")){
            sendTextMessageAsync("¡Hola! ¿Cuál es tu nombre?");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}