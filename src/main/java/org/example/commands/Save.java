package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.FileManager;

import java.io.IOException;

public class Save extends Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final String filePath;
    public Save(final CollectionManager collectionManager, FileManager fileManager, String filePath) {
        super("save", "save : сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.filePath = filePath;
    }


    @Override
    public void execute(String args) {
        if (!filePath.isBlank()) {
        try {
            fileManager.saveObj(filePath);
            System.out.println("объекты успешно сохранены!");
        } catch (IOException e) {
            System.err.println("Введен неверный путь");
        }
    }else {
            System.err.println("Пути нет.");
        }
    }
}
