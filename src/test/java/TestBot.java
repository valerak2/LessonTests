import ru.urfu.IBot;

import java.util.ArrayList;
import java.util.List;

public class TestBot implements IBot {

    private final List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }

    public String getLastMessage() {
        return messages.get(messages.size() - 1);
    }


    /**
     * Отправка сообщения пользователю
     *
     * @param id      идентификатор чата
     * @param message текст сообщения
     */
    @Override
    public void sendMessage(Long id, String message) {

    }

    /**
     * Функция для отправки сообщения с кнопками пользователю.
     *
     * @param id             - адрес отправки
     * @param message        - сообщение
     * @param keyboardLayout - вариант шаблона клавиатуры
     */
    @Override
    public void sendMessageWithButtons(Long id, String message, String keyboardLayout) {

    }
}
