package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.Label;

/**
 * Класс для построения объектов типа Label.
 * Наследует функциональность от абстрактного класса Builder.
 */
public class LabelBuilder extends Builder {

    /**
     * Создает объект типа Label, запрашивая у пользователя значения для полей name, bands и sales.
     *
     * @return объект типа Label
     * @throws InvalidDataException если введенные данные некорректны
     */
    public Label create() throws InvalidDataException {
        return new Label(buildString("name"), buildInt("bands"), buildSales("sales"));
    }
}