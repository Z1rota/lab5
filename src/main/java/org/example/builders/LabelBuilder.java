package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.Label;

public class LabelBuilder extends Builder {

    public Label create() throws InvalidDataException {
        return new Label(buildString("name"),buildInt("int bands"),buildSales("sales"));

    }
}
