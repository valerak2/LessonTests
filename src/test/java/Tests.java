import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.urfu.Core;
import ru.urfu.TimerBehavior;

import java.util.List;

public class Tests {
    private TestBot testBot;
    private Core core;

    @BeforeEach
    public void setUp() {
        testBot = new TestBot();
        core = new Core(testBot);
    }

    private void executeCommands(List<String> commands) {
        for (String command : commands) {
            core.processCommand(null, command);
        }
    }

    /**
     * Тестирование повторения тестов, где пользователь использовал команду /next
     * по примеру 1 задачи 2
     */
    @Test
    public void repetitionWithNext() {
        List<String> commands = List.of(
                "/test",
                "Неправильный ответ",
                "/next",
                "Правильный ответ",
                "/next");
        executeCommands(commands);

        String questionWithWrongAnswer = "Вычислите степень: 10^2";
        Assert.assertEquals(questionWithWrongAnswer,
                testBot.getLastMessage());
    }

    /**
     * Тестирование повторения тестов, где пользователь использовал команду /repeat
     * по примеру 2 задачи 2
     */
    @Test
    public void repetitionWithRepeat() {
        List<String> commands = List.of(
                "/test",
                "Неправильный ответ",
                "/stop",
                "/repeat");
        executeCommands(commands);

        String questionWithWrongAnswer = "Вычислите степень: 10^2";
        Assert.assertEquals(questionWithWrongAnswer,
                testBot.getLastMessage());
    }

    /**
     * Тестирование повторения тестов, где пользователь ответил на все вопросы правильно
     * и список вопросов для отработки пустой
     * по примеру 3 задачи 2
     */
    @Test
    public void ifUserGetAllCorrectAnswer() {
        List<String> commands = List.of(
                "/test",
                "Правильный ответ",
                "Правильный ответ",
                "/stop",
                "/repeat");
        executeCommands(commands);

        String expected = "Список вопросов для отработки пуст. Пройдите тест!";
        Assert.assertEquals(expected,
                testBot.getLastMessage());
    }


    /**
     * Тестирование возвращения вопроса из теста, соответствующего выбранному предмету
     * по примеру 1 задачи 3
     */
    @Test
    public void chooseSubject() {
        List<String> commands = List.of(
                "/start",
                "SUBJECT",
                "MATHS",
                "/test");
        executeCommands(commands);

        String mathQuestion = "Вычислите степень: 10^2";
        Assert.assertEquals(mathQuestion, testBot.getLastMessage());
    }

    /**
     * Тестирование возможности смены предмета
     * по примеру 2 задачи 3
     */
    @Test
    public void changeSubject() {
        List<String> commands = List.of(
                "/start",
                "SUBJECT",
                "MATHS",
                "/back",
                "ENGLISH");
        executeCommands(commands);
        String math = "Вы выбрали предмет математика, хотите начать тест (/test)?";
        String english = "Вы выбрали предмет английский, хотите начать тест (/test)?";

        Assert.assertEquals(math, testBot.getMessages().get(3));
        Assert.assertEquals(english, testBot.getMessages().get(5));
    }

    /**
     * Тестирование напоминания
     * по примеру 1 задачи 4
     */
    @Test
    public void reminderWorked() {
        List<String> commands = List.of(
                "/start",
                "/test",
                "/stop");
        String reminderMessage = "Вас давно не было видно. Хотите пройти тест?";
        executeCommands(commands);

        TimerBehavior.setStandardDispatchTime(24);

        Assert.assertEquals(reminderMessage, testBot.getLastMessage());
    }

    /**
     * Тестирование отключения напоминания
     * по примеру 2 задачи 4
     */

    @Test
    public void turnOffReminder() {
        List<String> commands = List.of(
                "/start",
                "timerOff");
        executeCommands(commands);
        String expected = "Уведомления успешно включены";

        Assert.assertEquals(expected, testBot.getLastMessage());
    }


}

