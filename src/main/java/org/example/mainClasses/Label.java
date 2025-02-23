package org.example.mainClasses;

import java.util.Objects;

/**
 * Класс, представляющий музыкальный лейбл с информацией о названии, количестве групп и продажах.
 */
public class Label implements Comparable<Label> {
    /**
     * Название лейбла.
     */
    private String name;

    /**
     * Количество групп на лейбле.
     */
    private int bands;

    /**
     * Общее количество продаж. Значение поля должно быть больше 0.
     */
    private long sales;

    /**
     * Конструктор для создания объекта Label.
     *
     * @param name название лейбла
     * @param bands количество групп на лейбле
     * @param sales общее количество продаж
     */
    public Label(String name, int bands, long sales) {
        this.name = name;
        this.bands = bands;
        this.sales = sales;
    }

    /**
     * Возвращает строковое представление лейбла в формате "Label: name bands: bands sales: sales".
     *
     * @return строковое представление лейбла
     */
    @Override
    public String toString() {
        return "Label: " + name + " bands: " + bands + " sales: " + sales;
    }

    /**
     * Сравнивает текущий лейбл с другим лейблом по имени.
     *
     * @param o лейбл для сравнения
     * @return отрицательное число, ноль или положительное число, если текущий лейбл меньше, равен или больше указанного
     */
    @Override
    public int compareTo(Label o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Возвращает название лейбла.
     *
     * @return название лейбла
     */
    public String getName() {
        return name;
    }

    /**
     * Проверяет, равен ли текущий объект другому объекту.
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return bands == label.bands && sales == label.sales && Objects.equals(name, label.name);
    }

    /**
     * Возвращает хэш-код для объекта Label.
     *
     * @return хэш-код для объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, bands, sales);
    }

    /**
     * Возвращает количество групп на лейбле.
     *
     * @return количество групп
     */
    public int getBands() {
        return this.bands;
    }

    /**
     * Возвращает общее количество продаж.
     *
     * @return общее количество продаж
     */
    public long getSales() {
        return this.sales;
    }
}