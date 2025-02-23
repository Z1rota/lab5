package org.example.commands;

import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

/**
 * Команда для удаления элемента, находящегося в заданной позиции коллекции.
 * Реализует абстрактный метод execute() из класса Command.
 */
public class RemoveAt extends Command {
    private final CollectionManager collectionManager; // Менеджер коллекции для удаления элемента

    /**
     * Конструктор команды RemoveAt.
     *
     * @param collectionManager менеджер коллекции, который предоставляет доступ к данным
     */
    public RemoveAt(CollectionManager collectionManager) {
        super("remove_at", "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды remove_at.
     * Удаляет элемент, находящийся в заданной позиции коллекции.
     *
     * @param args аргумент команды (индекс элемента для удаления)
     */
    @Override
    public void execute(String args) {
        try {
            int id = Integer.parseInt(args.trim()); // Преобразуем аргумент в число (индекс)
            collectionManager.removeAt(id); // Удаление элемента по индексу
            System.out.println("Объект успешно удален!");
        } catch (NoElementException e) {
            System.err.println("Элемента под этим индексом нет!"); // Обработка исключения, если элемента с таким индексом нет
        } catch (NumberFormatException e) {
            System.err.println("Введите число!"); // Обработка исключения, если аргумент не является числом
        }
    }
}