package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class RemoveFirst extends Command {
    private final CollectionManager collectionManager;


    public RemoveFirst(CollectionManager collectionManager) {
        super("remove_first","remove_first : удалить первый элемент из коллекции");
        this.collectionManager = collectionManager;

    }

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
