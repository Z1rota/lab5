package org.example.builders;

import org.example.exceptions.InvalidDataException;

import java.util.Date;

public class EstabilishmentDateBuilder extends Builder{

    public Date create() throws InvalidDataException {
        return new Date(buildInt("Год"),buildMonth("Месяц(0-11)"),buildDay("День(1-31)"));
    }
}
