package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class PrintDescending extends Command {
    private final CollectionManager collectionManager;

    public PrintDescending(CollectionManager collectionManager) {
        super("print_descending", "print_descending : вывести элементы коллекции в порядке убывания");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
    try {
        collectionManager.printAscend();
    } catch (EmptyCollectionException e) {
        System.err.println("Коллекция пуста!");
    }
    }

}
