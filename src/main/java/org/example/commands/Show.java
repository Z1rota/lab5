package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class Show extends Command {
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show","show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String args) {
        try {
            collectionManager.show();
        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!");
        }
    }
}
