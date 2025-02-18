package org.example.mainClasses;

import java.util.Objects;

public class Label implements Comparable<Label> {
    private String name;
    private int bands;
    private long sales; //Значение поля должно быть больше 0

    public Label(String name, int bands, long sales) {
        this.name = name;
        this.bands = bands;
        this.sales = sales;
    }
    @Override
    public String toString() {
        return "Label: " +name + " bands: " + bands + " sales: " + sales;
    }


    @Override
    public int compareTo(Label o) {
        return this.name.compareTo(o.name);
    }



    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return bands == label.bands && sales == label.sales && Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bands, sales);
    }
}

