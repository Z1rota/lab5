package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class PrintFieldAscendingLabel extends Command{
    private final CollectionManager collectionManager;
    public PrintFieldAscendingLabel(CollectionManager collectionManager) {
        super("print_field_ascending_label", "print_field_ascending_label : вывести значения поля label всех элементов в порядке возрастания");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws EmptyCollectionException {
        try {
            collectionManager.printLabelField();
        }catch (EmptyCollectionException e){
            System.err.println("Коллекция пуста!");
        }
    }
}
