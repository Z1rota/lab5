package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для вывода значений поля label всех элементов коллекции в порядке возрастания.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class PrintFieldAscendingLabel extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции для доступа к данным

    /**
     * Конструктор команды PrintFieldAscendingLabel.
     *
     * @param collectionManager менеджер коллекции, который предоставляет доступ к данным
     */
    public PrintFieldAscendingLabel(CollectionManager collectionManager) {
        super("print_field_ascending_label",
                "print_field_ascending_label : вывести значения поля label всех элементов в порядке возрастания");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды print_field_ascending_label.
     * Выводит значения поля label всех элементов коллекции в порядке возрастания.
     *
     * @param args аргументы команды (не используются в данной команде)
     * @throws EmptyCollectionException если коллекция пуста
     */
    @Override
    public void execute(String args) throws EmptyCollectionException {
        try {
            collectionManager.printLabelField(); // Вывод значений поля label в порядке возрастания
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!"); // Обработка исключения, если коллекция пуста
        }
    }
}