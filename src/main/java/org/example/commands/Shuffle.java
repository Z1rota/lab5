package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

/**
 * Команда для перемешивания элементов коллекции в случайном порядке.
 */
public class Shuffle extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для перемешивания элементов
     */
    public Shuffle(CollectionManager collectionManager) {
        super("shuffle", "shuffle : перемешать элементы коллекции в случайном порядке");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду перемешивания элементов коллекции.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.shuffle();
            System.out.println("Коллекция перемешана успешно!");
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!");
        }
    }
}