package org.example.commands;

import org.example.builders.MusicBandsBuilder;
import org.example.exceptions.InvalidDataException;
import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

/**
 * Команда для обновления значения элемента коллекции по заданному идентификатору.
 */
public class UpdateId extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для обновления элемента
     */
    public UpdateId(CollectionManager collectionManager) {
        super("update", "update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду обновления элемента коллекции по заданному идентификатору.
     *
     * @param args аргументы команды, содержащие идентификатор элемента для обновления
     */
    @Override
    public void execute(String args) {
        try {
            int id = Integer.parseInt(args.trim());
            collectionManager.updateId(id, new MusicBandsBuilder().create());
            System.out.println("Объект успешно изменен!");
        } catch (InvalidDataException e) {
            System.err.println("Введены неверные данные!");
        } catch (NoElementException e) {
            System.err.println("Объекта с таким id нет!");
        } catch (NumberFormatException e) {
            System.err.println("Введите значение типа long");
        }
    }
}