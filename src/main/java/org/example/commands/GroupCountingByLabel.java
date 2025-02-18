package org.example.commands;

import org.example.exceptions.EmptyCollectionException;
import org.example.managers.CollectionManager;

public class GroupCountingByLabel extends Command{
    private final CollectionManager collectionManager;
    public GroupCountingByLabel(CollectionManager collectionManager) {
        super("group_counting_by_label","group_counting_by_label : сгруппировать " +
                "элементы коллекции по значению поля label, вывести количество элементов в каждой группе");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String args) {
        try {
            collectionManager.groupByLabel();

        } catch (EmptyCollectionException e) {
            System.err.println("Коллекция пуста!");
        }
    }
}
