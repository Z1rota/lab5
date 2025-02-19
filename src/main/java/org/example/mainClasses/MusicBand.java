package org.example.mainClasses;

import org.example.utility.Validatable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MusicBand implements Validatable, Comparable<MusicBand> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private Date establishmentDate; //Поле может быть null
    private MusicGenre genre; //Поле может быть null
    private Label label; //Поле не может быть null
    private static long idcounter=1;

    public MusicBand( String name, Coordinates coordinates, LocalDateTime creationDate,
                     Integer numberOfParticipants, Date establishmentDate, MusicGenre genre, Label label) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.label = label;

    }
    public MusicBand( String name, Coordinates coordinates, Integer numberOfParticipants, java.util.Date
            establishmentDate, MusicGenre genre, Label label) {
        this(name, coordinates, LocalDateTime.now(), numberOfParticipants, establishmentDate, genre, label);
        this.id = idcounter;
        idcounter++;


    }

    public Label getLabel() {
        return label;
    }
    public String getLabelName() {
        return label.getName();
    }

    public String getLabels() {
        return label.toString();
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MusicBand{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"creationDate\": \"" + creationDate.format(DateTimeFormatter.ISO_DATE_TIME) + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"numberOfParticipants\": " + (numberOfParticipants == null ? "\"null" : "\""
                +numberOfParticipants) +"\", \"estabilishmentDate\":" + (establishmentDate == null ? "null" : "\" " +
                establishmentDate +"\", ") + "\"musicGenre\":" + (genre == null ? "null": "\"" + genre + "\"," +
                "\"label\":" + label);
    }

    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (numberOfParticipants <= 0) return false;
        if (label == null) return false;
    return true;
    }

    @Override
    public int compareTo(MusicBand o) {
        return (int) (this.id - o.id);
    }

    public String getName() {
        return this.name;
    }

    public MusicGenre getGenre() {
        return this.genre;
    }

    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
