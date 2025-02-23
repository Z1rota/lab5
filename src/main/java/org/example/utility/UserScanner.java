package org.example.utility;

import java.util.Scanner;

/**
 * Класс для управления сканером, используемым для ввода данных.
 * Предоставляет статический доступ к сканеру, который используется для чтения ввода пользователя.
 */
public class UserScanner {
    /**
     * Статический сканер для чтения ввода пользователя.
     * По умолчанию используется стандартный поток ввода (System.in).
     */
    public static Scanner customScanner = new Scanner(System.in);

    /**
     * Возвращает текущий сканер, используемый для ввода данных.
     *
     * @return текущий сканер
     */
    public static Scanner getUserScanner() {
        return customScanner;
    }
}