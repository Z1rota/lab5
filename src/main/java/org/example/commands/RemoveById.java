package org.example.commands;

import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

public class RemoveById extends Command {
    private final CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id","remove_by_id id : удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;

    }

    @Override
    public void execute(String args) {
        int id = Integer.parseInt(args.trim());
        try {
            collectionManager.removeById(id);
        } catch (NoElementException e) {
            System.err.println("элемента с таким id нет!");
        } catch (NumberFormatException e) {
            System.err.println("введите число!");
        }
    }

}
