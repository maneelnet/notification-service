package tasktrackerservice.spring.boot.notification.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tasktrackerservice.spring.boot.notification.api.dto.BugDto;
import tasktrackerservice.spring.boot.notification.api.dto.PageDto;
import tasktrackerservice.spring.boot.notification.config.BotConfig;

import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private BotConfig bot;
    private BugService bugService;
    private static int bugPage;

    @Override
    public String getBotToken() {
        String token = bot.getToken();
        return token;
    }

    @Override
    public String getBotUsername() {
        String name = bot.getName();
        return name;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            long telegramId = update.getMessage().getFrom().getId();
            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    System.out.println("Сообщение от пользователя: " + messageText);
                    break;
                case "/bugs":
                    bugPage = 0;
                    sendBugsMessage(chatId, telegramId, bugPage);
                    break;
                default:
                    sendMessage(chatId, "Данная команда пока не поддерживается!");
                    System.out.println("Сообщение от пользователя: " + messageText);
                break;
            }
        } else if (update.hasCallbackQuery()) {
            String callData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            long telegramId = update.getCallbackQuery().getFrom().getId();
            switch(callData) {
                case "nextPageBugs":
                    bugPage++;
                    sendBugsMessage(chatId, telegramId, bugPage);
                    break;
            }
        }
    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Привет, " + name + ", рад видеть тебя!";
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendBugsMessage(long chatId, long telegramId, int page) {
        SendMessage response = new SendMessage();
        StringBuilder message = new StringBuilder();
        PageDto<BugDto> pageDto = bugService.findAllByAssigneeId(telegramId, page);
        if (pageDto.getItems().size() > 0) {
            for(int i = 0; i < pageDto.getItems().size(); i++) {
                message.append(page * pageDto.getPageSize() + (i+1)).append(": ");
                message.append(pageDto.getItems().get(i).getName()).append("\n");
            }
        } else {
            message.append("Баги отсутствуют");
        }
        if (pageDto.getTotal() > page + 1) {
            response.setReplyMarkup(addInlineButton("Еще", "nextPageBugs"));
        }
        response.setChatId(chatId);
        response.setText(message.toString());
        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private InlineKeyboardMarkup addInlineButton(String name, String callback) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(name);
        button.setCallbackData(callback);
        List<InlineKeyboardButton> buttons = new LinkedList<>();
        List<List<InlineKeyboardButton>> buttonsRow = new LinkedList<>();
        buttons.add(button);
        buttonsRow.add(buttons);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttonsRow);
        return markupKeyboard;
    }
}
