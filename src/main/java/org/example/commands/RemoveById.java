package org.example.commands;

import org.example.exceptions.NoElementException;
import org.example.managers.CollectionManager;

/**
 * Команда для удаления элемента из коллекции по его идентификатору.
 */
public class RemoveById extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для удаления элемента
     */
    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "remove_by_id id : удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду удаления элемента из коллекции по указанному идентификатору.
     *
     * @param args аргументы команды, содержащие идентификатор элемента для удаления
     */
    @Override
    public void execute(String args) {
        long id = Long.parseLong(args.trim());
        try {
            collectionManager.removeById(id);
            System.out.println("Элемент с id " + id + " был успешно удален.");
        } catch (NoElementException e) {
            System.err.println("Элемента с id " + id + " нет!");
        } catch (NumberFormatException e) {
            System.err.println("Введите корректное число для id!");
        }
    }
}