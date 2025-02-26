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
        int year = buildInt("Год");
        int month = buildMonth("Месяц(0-11)");
        int day = buildDate("день",month,year);
        return new Date(year,month,day);
    }
}