package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.FileManager;

import java.io.IOException;

/**
 * Команда для сохранения коллекции в файл.
 */
public class Save extends Command {
    /**
     * Менеджер коллекции, используемый для управления элементами.
     */
    private final CollectionManager collectionManager;

    /**
     * Менеджер файлов, используемый для работы с файлами.
     */
    private final FileManager fileManager;

    /**
     * Путь к файлу, в который будет сохранена коллекция.
     */
    private final String filePath;

    /**
     * Конструктор команды.
     *
     * @param collectionManager менеджер коллекции, который будет использоваться для получения данных
     * @param fileManager менеджер файлов, который будет использоваться для сохранения данных
     * @param filePath путь к файлу, в который будет сохранена коллекция
     */
    public Save(final CollectionManager collectionManager, FileManager fileManager, String filePath) {
        super("save", "save : сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.filePath = filePath;
    }

    /**
     * Выполняет команду сохранения коллекции в файл.
     *
     * @param args аргументы команды (не используются в данной команде)
     */
    @Override
    public void execute(String args) {
        if (!filePath.isBlank()) {
            try {
                fileManager.saveObj(filePath);
                System.out.println("Объекты успешно сохранены!");
            } catch (IOException e) {
                System.err.println("Введен неверный путь");
            }
        } else {
            System.err.println("Пути нет.");
        }
    }
}