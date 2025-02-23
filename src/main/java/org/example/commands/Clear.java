package org.example.commands;

import org.example.exceptions.AlreadyEmptyException;
import org.example.managers.CollectionManager;

/**
 * Команда для очистки коллекции.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class Clear extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции, которую необходимо очистить

    /**
     * Конструктор команды Clear.
     *
     * @param collectionManager менеджер коллекции, которую нужно очистить
     */
    public Clear(CollectionManager collectionManager) {
        super("clear", "clear : очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды очистки коллекции.
     * Если коллекция пуста, выбрасывается исключение AlreadyEmptyException.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.clear(); // Очистка коллекции
            System.out.println("Очистка выполнена успешно!");
        } catch (AlreadyEmptyException e) {
            System.err.println("Коллекция пуста!"); // Обработка исключения, если коллекция уже пуста
        }
    }
}