package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.MusicBand;

public class MusicBandsBuilder extends Builder {


    public MusicBand create() throws InvalidDataException {
        return new MusicBand(buildString("name")
        ,new CoordinatesBuilder().create(),buildInt("кол-во участников"),
                new EstabilishmentDateBuilder().create(), new MusicGenreBuilder().create(),new LabelBuilder().create());
    }
}

