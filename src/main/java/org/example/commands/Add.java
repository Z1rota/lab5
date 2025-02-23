package org.example.commands;

import org.example.builders.MusicBandsBuilder;
import org.example.managers.CollectionManager;
import org.example.exceptions.InvalidDataException;

/**
 * Команда для добавления нового элемента в коллекцию.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class Add extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции, в которую добавляется элемент

    /**
     * Конструктор команды Add.
     *
     * @param collectionManager менеджер коллекции, в которую будет добавлен новый элемент
     */
    public Add(CollectionManager collectionManager) {
        super("add", "add {element} : добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды добавления элемента в коллекцию.
     * Создает объект MusicBand с помощью MusicBandsBuilder и добавляет его в коллекцию.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        try {
            System.out.println("Создание объекта MusicBand");
            collectionManager.add(new MusicBandsBuilder().create()); // Создание и добавление элемента
            System.out.println("Объект создан успешно!");
        } catch (InvalidDataException e) {
            System.err.println("Данные некорректны"); // Обработка исключения при некорректных данных
        }
    }
}