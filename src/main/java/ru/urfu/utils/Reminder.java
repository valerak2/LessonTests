package ru.urfu.utils;

import ru.urfu.IBot;

import java.util.TimerTask;

import static ru.urfu.constants.CommandConstants.REMINDER;

/**
 * Класс создания напоминания пользователю.
 * @see ru.urfu.TimerBehavior#setReminder(IBot)
 * @author Пономарева Дарья, Бабакова Анастасия.
 */
public class Reminder extends TimerTask {
    /** Функционал бота */
    IBot bot;
    /** Поле пользователя, которому отправляется напоминание */
    Long user;

    /** Конструктор класса */
    public Reminder(IBot bot, Long user){
        this.bot = bot;
        this.user = user;
    }

    /**
     * Функция создания задания для таймера
     * @see TimerTask#run()
     */
    @Override
    public void run() {
        bot.sendMessageWithButtons(user, REMINDER, "SUBJECT_BOARD");
    }
}