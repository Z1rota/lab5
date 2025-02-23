package org.example.commands;

/**
 * Абстрактный класс, представляющий команду.
 * Каждая команда имеет имя, описание и метод для выполнения.
 */
public abstract class Command {
    private final String name; // Название команды
    private final String description; // Описание команды

    /**
     * Конструктор для создания команды.
     *
     * @param name название команды
     * @param description описание команды
     */
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Возвращает описание команды.
     *
     * @return описание команды
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает название команды.
     *
     * @return название команды
     */
    public String getName() {
        return name;
    }

    /**
     * Абстрактный метод для выполнения команды.
     * Должен быть реализован в подклассах.
     *
     * @param args аргументы команды
     */
    public abstract void execute(String args);
}