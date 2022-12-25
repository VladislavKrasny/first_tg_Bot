import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "overone_mymusic_bot";
    }

    @Override
    public String getBotToken() {
        return "5884766048:AAHUQoa3uQ0-SGN3AbWQ0HVSErAaNx5rmDI";
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Linkin Park - What I've Done"));
        keyboardRow1.add(new KeyboardButton("Gorillaz - Feel good"));
        keyboardRow1.add(new KeyboardButton("Ariya - Angelskaya pil"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Linkin Park - The End"));
        keyboardRow2.add(new KeyboardButton("Баста - Моя игра"));
        keyboardRow2.add(new KeyboardButton("The Cranberries - Zombie"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);

        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()){
            case "Linkin Park - What I've Done" :
                inputFile.setMedia("CQACAgIAAxkBAAMFY6iWzVZA0FqgzraI10m8_fAVV5cAAlwnAAI4YUFJdhO78moGDOosBA");
                break;
            case "Gorillaz - Feel good" :
                inputFile.setMedia("CQACAgIAAxkBAAMIY6iW9DlB9ITySmiOA2ZlgSCLsaoAAl4nAAI4YUFJZXO_D14itaosBA");
                break;
            case "Ariya - Angelskaya pil" :
                inputFile.setMedia("CQACAgIAAxkBAAMKY6iXLrjWaLvrLkgF3CU8zoBLE6gAAmAnAAI4YUFJ1JFQbzJ2UGwsBA");
                break;
            case "Linkin Park - The End" :
                inputFile.setMedia("CQACAgIAAxkBAAMMY6iXNjJtcdamnGq24XbSCOB8CWAAAmInAAI4YUFJvMyxLDUZBI8sBA");
                break;
            case "Баста - Моя игра" :
                inputFile.setMedia("CQACAgIAAxkBAAMOY6iXPyRMwnWFa57mNH6tEHwIBjsAAmMnAAI4YUFJPMuBPf_5710sBA");
                break;
            case "The Cranberries - Zombie" :
                inputFile.setMedia("CQACAgIAAxkBAAMQY6iYDMD0WyJKdEz2Mjt51HjxyZkAAnAnAAI4YUFJfPWbVPcC8N0sBA");
                break;
        }

        sendAudio.setAudio(inputFile);
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        

    }
}
