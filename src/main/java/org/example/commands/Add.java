package org.example.commands;

import org.example.builders.MusicBandsBuilder;
import org.example.managers.CollectionManager;
import org.example.exceptions.InvalidDataException;

public class Add extends Command {
    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        super("add","add {element} : добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            System.out.println("Создание объекта MusicBand");
            collectionManager.add(new MusicBandsBuilder().create());
            System.out.println("Объект создан успешно!");

        }catch (InvalidDataException e) {
            System.err.println("Данные неккоректны");
        }
    }
}
