package org.example.commands;

import org.example.managers.CommandManager;
import org.example.managers.ScriptExecuteManager;
import org.example.utility.FileMode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Команда для выполнения скрипта из указанного файла.
 * Реализует абстрактный метод execute() из класса Command.
 * Скрипт содержит команды в том же формате, что и ввод пользователя в интерактивном режиме.
 */
public class ExecuteScript extends Command {
    private final CommandManager commandManager; // Менеджер команд для выполнения команд из скрипта

    /**
     * Конструктор команды ExecuteScript.
     *
     * @param commandManager менеджер команд, который будет выполнять команды из скрипта
     */
    public ExecuteScript(CommandManager commandManager) {
        super("execute_script", "execute_script file_name : " +
                "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, " +
                "в котором их вводит пользователь в интерактивном режиме.");
        this.commandManager = commandManager;
    }

    /**
     * Метод для выполнения команды execute_script.
     * Читает команды из указанного файла и выполняет их.
     *
     * @param args путь к файлу со скриптом
     */
    @Override
    public void execute(String args) {
        String path = args.trim(); // Убираем лишние пробелы в пути к файлу
        try {
            FileMode.setFileMode(true); // Устанавливаем режим работы с файлом
            ScriptExecuteManager.pushFile(path); // Добавляем файл в стек для обработки
            boolean isEmpty = true;
            for (String line = ScriptExecuteManager.readfile(); line != null; line = ScriptExecuteManager.readfile()) {
                isEmpty = false;
                try {
                    String[] cmd = (line + " ").split(" ", 2); // Разделяем команду и аргументы
                    if (cmd[0].isBlank()) return; // Пропускаем пустые строки
                    if (cmd[0].equals("execute_script")) {
                        if (ScriptExecuteManager.IsRepeat(cmd[1])) {
                            System.err.println("Найдена рекурсия"); // Проверка на рекурсию
                            continue;
                        }
                    }
                    System.out.println("Выполнение команды " + cmd[0]); // Логирование выполняемой команды
                    commandManager.execute(cmd[0], cmd[1]); // Выполнение команды
                    if (cmd[0].equals("execute_script")) {
                        ScriptExecuteManager.popfile(); // Убираем файл из стека после выполнения вложенного скрипта
                    }
                } catch (NoSuchElementException ignored) {
                    // Игнорируем исключение, если команда не найдена
                }
                if (isEmpty) {
                    System.err.println("Файл пустой!"); // Сообщение, если файл пустой
                }
            }
            ScriptExecuteManager.popfile(); // Убираем файл из стека после завершения выполнения
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Такого файла не существует"); // Обработка ошибки отсутствия файла
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода"); // Обработка ошибок ввода-вывода
        } catch (NoSuchElementException ignored) {
            // Игнорируем исключение, если команда не найдена
        }
        FileMode.setFileMode(false); // Возвращаемся в интерактивный режим
    }
}