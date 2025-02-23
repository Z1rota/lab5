package org.example.managers;

import org.example.commands.Command;

import java.util.HashMap;

/**
 * Класс для управления командами.
 * Реализует регистрацию, хранение и выполнение команд.
 */
public class CommandManager {
    /**
     * Коллекция для хранения команд.
     * Ключ — название команды, значение — объект команды.
     */
    private HashMap<String, Command> commands = new HashMap<>();

    /**
     * Добавляет команду в коллекцию.
     *
     * @param command команда для добавления
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * Возвращает коллекцию зарегистрированных команд.
     *
     * @return коллекция команд
     */
    public HashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * Выполняет команду по её названию.
     *
     * @param name название команды
     * @param args аргументы команды
     */
    public void execute(String name, String args) {
        Command command = this.commands.get(name);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Такой команды нет!");
        }
    }
}