package org.example.commands;

import org.example.builders.MusicBandsBuilder;
import org.example.exceptions.InvalidDataException;
import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

public class UpdateId extends Command{
    private final CollectionManager collectionManager;
    public UpdateId(CollectionManager collectionManager) {
        super("update_id", "update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String args) {
    try {


        int id = Integer.parseInt(args.trim());
        collectionManager.updateId(id, new MusicBandsBuilder().create());
        System.out.println("объект успешно изменен!");

    }catch (InvalidDataException e) {
        System.err.println("Введены неверные данные!");
    } catch (NoElementException e) {
        System.err.println("Объекта с таким id нет!");
    }catch (NumberFormatException e) {
        System.err.println("Введите значение типа long");
    }
    }
}

