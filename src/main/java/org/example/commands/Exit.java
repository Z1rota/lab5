package org.example.commands;

import org.example.managers.CollectionManager;

public class Exit extends Command {
    private final CollectionManager collectionManager;

    public Exit(CollectionManager collectionManager) {
        super("exit", "exit : завершить программу (без сохранения в файл)");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String args) {
        System.exit(0);
    }
}
