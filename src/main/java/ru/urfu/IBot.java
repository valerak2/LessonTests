package ru.urfu;

/**
 * Интерфейс Бота со списком его возможностей.
 *
 * @author Бабакова Анастасия, Пономарева Дарья
 */
public interface IBot {
    /**
     * Отправка сообщения пользователю
     *
     * @param id идентификатор чата
     * @param message текст сообщения
     */
    void sendMessage(Long id, String message);

    /**
     * Функция для отправки сообщения с кнопками пользователю.
     *
     * @param id - адрес отправки
     * @param message - сообщение
     * @param keyboardLayout - вариант шаблона клавиатуры
     */
    void sendMessageWithButtons(Long id, String message, String keyboardLayout);
}
