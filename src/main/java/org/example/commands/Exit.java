package org.example.commands;

import org.example.managers.CollectionManager;

/**
 * Команда для завершения работы программы.
 * Реализует абстрактный метод execute() из класса Command.
 * Программа завершается без сохранения данных в файл.
 */
public class Exit extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции (не используется в данной команде)

    /**
     * Конструктор команды Exit.
     *
     * @param collectionManager менеджер коллекции (передается для совместимости, но не используется)
     */
    public Exit(CollectionManager collectionManager) {
        super("exit", "exit : завершить программу (без сохранения в файл)");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды exit.
     * Завершает работу программы с кодом 0 (успешное завершение).
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        System.exit(0); // Завершение программы
    }
}