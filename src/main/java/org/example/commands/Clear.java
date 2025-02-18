package org.example.commands;

import org.example.exceptions.AlreadyEmptyException;
import org.example.managers.CollectionManager;

public class Clear extends Command{
    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear","clear : очистить коллекцию");
        this.collectionManager= collectionManager;

    }



    @Override
    public void execute(String args) {
        try {
            collectionManager.clear();
            System.out.println("Очистка выполнена успешно!");
        } catch (AlreadyEmptyException e) {
            System.err.println("Коллекция пуста!");
        }
    }

}
