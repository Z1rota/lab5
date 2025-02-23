package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.Coordinates;

/**
 * Класс для построения объектов типа Coordinates.
 * Наследует функциональность от абстрактного класса Builder.
 */
public class CoordinatesBuilder extends Builder {

    /**
     * Создает объект типа Coordinates, запрашивая у пользователя значения для полей x и y.
     *
     * @return объект типа Coordinates
     * @throws InvalidDataException если введенные данные некорректны
     */
    public Coordinates create() throws InvalidDataException {
        return new Coordinates(buildFloat("значение x"), buildLong("значение y"));
    }
}