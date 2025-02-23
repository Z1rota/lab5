package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для удаления первого элемента из коллекции.
 */
public class RemoveFirst extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для удаления первого элемента
     */
    public RemoveFirst(CollectionManager collectionManager) {
        super("remove_first", "remove_first : удалить первый элемент из коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду удаления первого элемента из коллекции.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            System.out.println("Удаление первого элемента");
            collectionManager.removeFirst();
            System.out.println("Элемент успешно удален!");
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!");
        }
    }
}