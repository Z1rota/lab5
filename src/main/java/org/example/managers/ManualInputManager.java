package org.example.managers;

import org.example.utility.Reader;
import org.example.utility.UserScanner;

import java.util.Scanner;

/**
 * Класс для ручного ввода данных от пользователя.
 * Реализует интерфейс {@link Reader} для чтения строк ввода.
 */
public class ManualInputManager implements Reader {
    /**
     * Сканер для чтения ввода пользователя.
     * Используется статический экземпляр сканера из класса {@link UserScanner}.
     */
    private static final Scanner userScanner = UserScanner.getUserScanner();

    /**
     * Читает следующую строку ввода от пользователя.
     *
     * @return строка, введенная пользователем
     */
    @Override
    public String nextLine() {
        return userScanner.nextLine();
    }
}