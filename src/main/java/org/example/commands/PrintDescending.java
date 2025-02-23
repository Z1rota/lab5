package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для вывода элементов коллекции в порядке убывания.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class PrintDescending extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции для вывода элементов

    /**
     * Конструктор команды PrintDescending.
     *
     * @param collectionManager менеджер коллекции, который предоставляет доступ к данным коллекции
     */
    public PrintDescending(CollectionManager collectionManager) {
        super("print_descending", "print_descending : вывести элементы коллекции в порядке убывания");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды print_descending.
     * Выводит элементы коллекции в порядке убывания.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.printAscend(); // Вывод элементов коллекции в порядке убывания
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!"); // Обработка исключения, если коллекция пуста
        }
    }
}