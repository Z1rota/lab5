package org.example;

import org.example.managers.*;
import org.example.commands.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();
        FileManager fileManager = new FileManager(collectionManager);
        RunManager runManager = new RunManager(commandManager);
        if (args.length != 0) {
            try {
                fileManager.readFromCollection(args[0]);
            } catch (IOException e) {
                System.err.println("Ошибка чтения");
            }
            System.out.println("коллекция загружена");
        } else {
            args =  new String[] {" "};
            System.out.println("Файл не найден");

        }

        commandManager.addCommand(new Add(collectionManager));
        commandManager.addCommand(new Clear(collectionManager));
        commandManager.addCommand(new ExecuteScript(commandManager));
        commandManager.addCommand(new Exit(collectionManager));
        commandManager.addCommand(new GroupCountingByLabel(collectionManager));
        commandManager.addCommand(new Help(collectionManager,commandManager));
        commandManager.addCommand(new Info(collectionManager));
        commandManager.addCommand(new PrintDescending(collectionManager));
        commandManager.addCommand(new PrintFieldAscendingLabel(collectionManager));
        commandManager.addCommand(new RemoveAt(collectionManager));
        commandManager.addCommand(new RemoveById(collectionManager));
        commandManager.addCommand(new RemoveFirst(collectionManager));
        commandManager.addCommand(new Save(collectionManager,fileManager,args[0]));
        commandManager.addCommand(new Show(collectionManager));
        commandManager.addCommand(new Shuffle(collectionManager));
        commandManager.addCommand(new UpdateId(collectionManager));


        runManager.run();

    }
}