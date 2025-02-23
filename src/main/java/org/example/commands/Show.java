package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для вывода всех элементов коллекции в строковом представлении.
 */
public class Show extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для получения данных
     */
    public Show(CollectionManager collectionManager) {
        super("show", "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду вывода всех элементов коллекции.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.show();
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!");
        }
    }
}