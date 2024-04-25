package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_3_TEXT;
//import static java.util.Map.*;

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
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera", "step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, Map.of("¡Tomar 1 salchicha", "step_2_btn",
                                                        "¡Tomar 1 pescado", "step_2_btn",
                                                        "¡Tirar una lata de pepinillos", "step_2_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Romper al robot aspiradora archienemigo", "step_3_btn"));
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}