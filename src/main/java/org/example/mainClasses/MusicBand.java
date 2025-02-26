package org.example.mainClasses;

import org.example.utility.Validatable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Класс, представляющий музыкальную группу.
 * Реализует интерфейсы {@link Validatable} и {@link Comparable<MusicBand>}.
 */
public class MusicBand implements Validatable, Comparable<MusicBand> {
    /**
     * Уникальный идентификатор музыкальной группы.
     * Значение должно быть больше 0, уникальным и генерироваться автоматически.
     */
    private long id;

    /**
     * Название музыкальной группы.
     * Поле не может быть null, строка не может быть пустой.
     */
    private String name;

    /**
     * Координаты музыкальной группы.
     * Поле не может быть null.
     */
    private Coordinates coordinates;

    /**
     * Дата создания записи о музыкальной группе.
     * Поле не может быть null, значение генерируется автоматически.
     */
    private LocalDateTime creationDate;

    /**
     * Количество участников музыкальной группы.
     * Поле может быть null, значение должно быть больше 0.
     */
    private Integer numberOfParticipants;

    /**
     * Дата основания музыкальной группы.
     * Поле может быть null.
     */
    private Date establishmentDate;

    /**
     * Жанр музыкальной группы.
     * Поле может быть null.
     */
    private MusicGenre genre;

    /**
     * Лейбл музыкальной группы.
     * Поле не может быть null.
     */
    private Label label;

    /**
     * Счетчик для автоматической генерации уникального идентификатора.
     */
    public static long idcounter = 1;

    /**
     * Конструктор для создания объекта MusicBand.
     *
     * @param name                название группы
     * @param coordinates         координаты группы
     * @param creationDate        дата создания записи
     * @param numberOfParticipants количество участников
     * @param establishmentDate   дата основания группы
     * @param genre               жанр музыки
     * @param label               лейбл группы
     */
    public MusicBand(String name, Coordinates coordinates, LocalDateTime creationDate,
                     Integer numberOfParticipants, Date establishmentDate, MusicGenre genre, Label label) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.label = label;
    }

    /**
     * Упрощенный конструктор для создания объекта MusicBand.
     * Автоматически генерирует id и creationDate.
     *
     * @param name                название группы
     * @param coordinates         координаты группы
     * @param numberOfParticipants количество участников
     * @param establishmentDate   дата основания группы
     * @param genre               жанр музыки
     * @param label               лейбл группы
     */
    public MusicBand(String name, Coordinates coordinates, Integer numberOfParticipants, Date establishmentDate,
                     MusicGenre genre, Label label) {
        this(name, coordinates, LocalDateTime.now(), numberOfParticipants, establishmentDate, genre, label);
        this.id = idcounter;
        if (validate()) {
            idcounter++;
        }

    }

    /**
     * Возвращает лейбл музыкальной группы.
     *
     * @return лейбл группы
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Возвращает название лейбла музыкальной группы.
     *
     * @return название лейбла
     */
    public String getLabelName() {
        return label.getName();
    }

    /**
     * Возвращает строковое представление лейбла.
     *
     * @return строковое представление лейбла
     */
    public String getLabels() {
        return label.toString();
    }

    /**
     * Возвращает идентификатор музыкальной группы.
     *
     * @return идентификатор группы
     */
    public long getId() {
        return this.id;
    }

    /**
     * Устанавливает идентификатор музыкальной группы.
     *
     * @param id идентификатор группы
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает строковое представление объекта MusicBand.
     *
     * @return строковое представление группы
     */
    @Override
    public String toString() {
        return "MusicBand{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"creationDate\": \"" + creationDate.format(DateTimeFormatter.ISO_DATE_TIME) + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"numberOfParticipants\": " + (numberOfParticipants == null ? "\"null" : "\""
                + numberOfParticipants) + "\", \"estabilishmentDate\":" + (establishmentDate == null ? "null" : "\" " +
                establishmentDate + "\", ") + "\"musicGenre\":" + (genre == null ? "null" : "\"" + genre + "\"," +
                "\"label\":" + label);
    }

    /**
     * Проверяет валидность объекта MusicBand.
     *
     * @return true, если объект валиден, иначе false
     */
    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (numberOfParticipants != null && numberOfParticipants <= 0) return false;
        if (label == null) return false;
        return true;
    }

    /**
     * Сравнивает текущий объект MusicBand с другим объектом MusicBand по идентификатору.
     *
     * @param o объект для сравнения
     * @return результат сравнения (разница идентификаторов)
     */
    @Override
    public int compareTo(MusicBand o) {
        return (int) (this.id - o.id);
    }

    /**
     * Возвращает название музыкальной группы.
     *
     * @return название группы
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает жанр музыкальной группы.
     *
     * @return жанр музыки
     */
    public MusicGenre getGenre() {
        return this.genre;
    }

    /**
     * Возвращает количество участников музыкальной группы.
     *
     * @return количество участников
     */
    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    /**
     * Возвращает координаты музыкальной группы.
     *
     * @return координаты группы
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}