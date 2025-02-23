package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для группировки элементов коллекции по значению поля label.
 * Реализует абстрактный метод execute() из класса Command.
 * Выводит количество элементов в каждой группе.
 */
public class GroupCountingByLabel extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции для выполнения группировки

    /**
     * Конструктор команды GroupCountingByLabel.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для группировки
     */
    public GroupCountingByLabel(CollectionManager collectionManager) {
        super("group_counting_by_label", "group_counting_by_label : сгруппировать " +
                "элементы коллекции по значению поля label, вывести количество элементов в каждой группе");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды group_counting_by_label.
     * Группирует элементы коллекции по значению поля label и выводит количество элементов в каждой группе.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.groupByLabel(); // Выполнение группировки
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!"); // Обработка исключения, если коллекция пуста
        }
    }
}