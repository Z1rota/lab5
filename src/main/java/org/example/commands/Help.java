package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;

/**
 * Команда для вывода справки по доступным командам.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class Help extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции (не используется в данной команде)
    private final CommandManager commandManager; // Менеджер команд для получения списка доступных команд

    /**
     * Конструктор команды Help.
     *
     * @param collectionManager менеджер коллекции (передается для совместимости, но не используется)
     * @param commandManager менеджер команд, который предоставляет список доступных команд
     */
    public Help(CollectionManager collectionManager, CommandManager commandManager) {
        super("help", "help : вывести справку по доступным командам");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }

    /**
     * Метод для выполнения команды help.
     * Выводит список всех доступных команд и их описание.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        System.out.println("Список команд: ");
        // Вывод описания каждой команды
        commandManager.getCommands().values().forEach(command -> System.out.println(command.getDescription()));
    }
}