package org.example.commands;

import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

public class RemoveAt extends Command{
    private final CollectionManager collectionManager;
    public RemoveAt(CollectionManager collectionManager) {
        super("remove_at", "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            int id = Integer.parseInt(args.trim());
            collectionManager.removeAt(id);
            System.out.println("Объект успешно удален!");

        } catch (NoElementException e) {
            System.err.println("Элемента под этим индексом нет!");
        } catch (NumberFormatException e) {
            System.err.println("Введите число!");
        }
    }
}
