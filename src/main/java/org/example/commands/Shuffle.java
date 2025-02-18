package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class Shuffle extends Command {
    private final CollectionManager collectionManager;


    public Shuffle(CollectionManager collectionManager) {
        super("shuffle", "shuffle : перемешать элементы коллекции в случайном порядке");
        this.collectionManager = collectionManager;
    }

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

