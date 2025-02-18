package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;


public class Help extends Command {
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;

    public Help(CollectionManager collectionManager, CommandManager commandManager) {
        super("help", "help : вывести справку по доступным командам");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }





    @Override
    public void execute(String args) {
        System.out.println("Список команд: ");
        commandManager.getCommands().values().forEach(command -> System.out.println(command.getDescription()));




    }
}
