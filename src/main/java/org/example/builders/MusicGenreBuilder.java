package org.example.builders;

import org.example.mainClasses.MusicGenre;

/**
 * Класс для построения объектов типа MusicGenre.
 * Наследует функциональность от абстрактного класса Builder.
 * Позволяет пользователю выбрать жанр музыки из доступных вариантов.
 */
public class MusicGenreBuilder extends Builder {

    /**
     * Создает объект типа MusicGenre, запрашивая у пользователя выбор жанра из доступных вариантов.
     *
     * @return объект типа MusicGenre, соответствующий введенному пользователем жанру
     */
    public MusicGenre create() {
        System.out.println("Жанры музыки: ");
        System.out.println(MusicGenre.names()); // Выводим список доступных жанров

        while (true) {
            String input = scanner.nextLine().trim(); // Читаем ввод пользователя
            try {
                return MusicGenre.valueOf(input.toUpperCase()); // Пытаемся преобразовать ввод в значение перечисления
            } catch (IllegalArgumentException e) {
                System.err.println("Такого жанра нет"); // Если жанр не найден, выводим сообщение об ошибке
            }
        }
    }
}