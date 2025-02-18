package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.Coordinates;

public class CoordinatesBuilder extends Builder {



    public Coordinates create() throws InvalidDataException {
        return new Coordinates(buildFloat("значение x"),buildLong("значение y"));

    }
}
