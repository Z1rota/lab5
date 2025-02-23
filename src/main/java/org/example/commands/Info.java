package org.example.commands;

import org.example.managers.CollectionManager;

public class Info extends Command {
    private final CollectionManager collectionManager;
    public Info(CollectionManager collectionManager) {
        super("info", "info : вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        System.out.println("информация о коллекции: ");
        System.out.println(collectionManager.info());

    }

}

