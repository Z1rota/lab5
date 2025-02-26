package org.example.managers;

import org.example.utility.UserScanner;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для управления выполнением команд.
 * Обеспечивает чтение команд от пользователя и их выполнение.
 */
public class RunManager {
    /**
     * Менеджер команд, который используется для выполнения команд.
     */
    private final CommandManager commandManager;

    /**
     * Конструктор класса RunManager.
     *
     * @param commandManager менеджер команд, который будет использоваться для выполнения команд
     */
    public RunManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * Основной метод для запуска цикла выполнения команд.
     * Читает команды от пользователя и передает их на выполнение в CommandManager.
     */
    public void run() {
        try {
            Scanner scanner = UserScanner.getUserScanner(); // Сканер для чтения ввода пользователя
            while (true) {
                String input = scanner.nextLine().trim() + " "; // Чтение ввода пользователя
                String[] command = input.split(" ", 2); // Разделение ввода на команду и аргументы
                commandManager.execute(command[0], command[1]); // Выполнение команды
            }
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
    }
}