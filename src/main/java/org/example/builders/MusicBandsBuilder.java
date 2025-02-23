package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.MusicBand;

/**
 * Класс для построения объектов типа MusicBand.
 * Наследует функциональность от абстрактного класса Builder.
 * Использует другие билдеры для создания сложных объектов, таких как Coordinates, EstabilishmentDate и Label.
 */
public class MusicBandsBuilder extends Builder {

    /**
     * Создает объект типа MusicBand, запрашивая у пользователя значения для всех необходимых полей.
     *
     * @return объект типа MusicBand
     * @throws InvalidDataException если введенные данные некорректны
     */
    public MusicBand create() throws InvalidDataException {
        return new MusicBand(
                buildString("name"), // Запрашиваем название группы
                new CoordinatesBuilder().create(), // Создаем объект Coordinates с помощью CoordinatesBuilder
                buildInt("кол-во участников"), // Запрашиваем количество участников
                new EstabilishmentDateBuilder().create(), // Создаем дату основания с помощью EstabilishmentDateBuilder
                new MusicGenreBuilder().create(), // Создаем жанр музыки с помощью MusicGenreBuilder
                new LabelBuilder().create() // Создаем лейбл с помощью LabelBuilder
        );
    }
}