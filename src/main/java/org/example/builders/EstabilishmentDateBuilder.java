package org.example.builders;

import org.example.exceptions.InvalidDataException;

import java.util.Date;

/**
 * Класс для построения объектов типа Date, представляющих дату основания.
 * Наследует функциональность от абстрактного класса Builder.
 */
public class EstabilishmentDateBuilder extends Builder {

    /**
     * Создает объект типа Date, запрашивая у пользователя значения для года, месяца и дня.
     *
     * @return объект типа Date, представляющий дату основания
     * @throws InvalidDataException если введенные данные некорректны
     */
    public Date create() throws InvalidDataException {
        return new Date(buildInt("Год"), buildMonth("Месяц(0-11)"), buildDay("День(1-31)"));
    }
}