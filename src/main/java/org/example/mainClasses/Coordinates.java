package org.example.mainClasses;

public class Coordinates {
    private Float x; //Поле не может быть null
    private long y; //Максимальное значение поля: 968

    public Coordinates(Float x, long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return x + ";" + y;
    }
}
