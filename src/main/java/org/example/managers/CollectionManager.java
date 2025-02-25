package org.example.managers;

import org.example.exceptions.AlreadyEmptyException;
import org.example.exceptions.EmptyCollectionException;
import org.example.exceptions.InvalidDataException;
import org.example.exceptions.NoElementException;
import org.example.mainClasses.Label;
import org.example.mainClasses.MusicBand;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для управления коллекцией музыкальных групп.
 * Реализует основные операции для работы с коллекцией, такие как добавление, удаление, поиск и сортировка.
 */
public class CollectionManager {
    private Stack<MusicBand> bands = new Stack<MusicBand>(); // Коллекция музыкальных групп
    private LocalDate date; // Дата создания коллекции

    /**
     * Конструктор по умолчанию.
     * Инициализирует дату создания коллекции текущей датой.
     */
    public CollectionManager() {
        this.date = LocalDate.parse(LocalDate.now().toString());
    }

    /**
     * Возвращает коллекцию музыкальных групп.
     *
     * @return коллекция музыкальных групп
     */
    public Stack<MusicBand> getBands() {
        return this.bands;
    }

    /**
     * Группирует музыкальные группы по лейблу и выводит результат.
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void groupByLabel() throws EmptyCollectionException {
        if (bands.isEmpty()) {
            throw new EmptyCollectionException();
        }
        Map<Label, List<MusicBand>> grouped = bands.stream().collect(Collectors.groupingBy(MusicBand::getLabel));
        for (Map.Entry<Label, List<MusicBand>> entry : grouped.entrySet()) {
            String label = entry.getKey().toString();
            List<MusicBand> musicBands = entry.getValue();
            System.out.println(label + ", Count: " + musicBands.size());
            for (MusicBand musicBand : musicBands) {
                System.out.println("Value: " + musicBand.toString());
            }
        }
    }

    /**
     * Устанавливает дату создания коллекции.
     *
     * @param date дата создания коллекции
     */
    public void setLocaleDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Возвращает дату создания коллекции.
     *
     * @return дата создания коллекции
     */
    public LocalDate getLocaleDate() {
        return this.date;
    }

    /**
     * Проверяет, существует ли в коллекции группа с таким же идентификатором.
     *
     * @param musicBand музыкальная группа для проверки
     * @return true, если идентификатор уникален, иначе false
     */
    public boolean checkId(MusicBand musicBand) {
        for (MusicBand band : bands) {
            if (musicBand.getId() == band.getId()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, есть ли в коллекции группы с одинаковыми идентификаторами.
     *
     * @return true, если все идентификаторы уникальны, иначе false
     */
    public boolean checkSameId() {
        Set<Long> ids = new HashSet<>();
        for (MusicBand band : bands) {
            if (!ids.add(band.getId())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Добавляет коллекцию музыкальных групп в текущую коллекцию.
     *
     * @param collection коллекция музыкальных групп для добавления
     * @throws InvalidDataException если данные группы невалидны
     */
    public void addElem(Collection<MusicBand> collection) throws InvalidDataException {
        if (collection == null) return;
        for (MusicBand band : collection) {
            add(band);
        }
    }

    /**
     * Добавляет музыкальную группу в коллекцию.
     *
     * @param band музыкальная группа для добавления
     * @throws InvalidDataException если данные группы невалидны
     */
    public void add(MusicBand band) throws InvalidDataException {
        if (!band.validate()) {
            throw new InvalidDataException();
        }
        while (!checkId(band)) {
            MusicBand.idcounter++;
            band.setId(MusicBand.idcounter);
        }
        bands.add(band);
    }

    /**
     * Возвращает музыкальную группу по идентификатору.
     *
     * @param id идентификатор группы
     * @return музыкальная группа или null, если группа не найдена
     */
    public MusicBand getById(long id) {
        for (MusicBand band : bands) {
            if (band.getId() == id) return band;
        }
        return null;
    }

    /**
     * Удаляет музыкальную группу по идентификатору.
     *
     * @param id идентификатор группы
     * @throws NoElementException если группа с таким идентификатором не найдена
     */
    public void removeById(long id) throws NoElementException {
        MusicBand band = getById(id);
        if (band == null) {
            throw new NoElementException();
        }
        bands.remove(band);
    }

    /**
     * Проверяет, содержится ли группа в коллекции.
     *
     * @param band музыкальная группа для проверки
     * @return true, если группа содержится в коллекции, иначе false
     */
    public boolean isContain(MusicBand band) {
        return band != null && getById(band.getId()) != null;
    }

    /**
     * Очищает коллекцию.
     *
     * @throws AlreadyEmptyException если коллекция уже пуста
     */
    public void clear() throws AlreadyEmptyException {
        if (bands.isEmpty()) {
            throw new AlreadyEmptyException();
        }
        bands.clear();
    }

    /**
     * Возвращает дату создания коллекции.
     *
     * @return дата создания коллекции
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Возвращает тип коллекции.
     *
     * @return тип коллекции
     */
    public String getTypeOfCollection() {
        return "Stack";
    }

    /**
     * Возвращает размер коллекции.
     *
     * @return размер коллекции
     */
    public int size() {
        return bands.size();
    }

    /**
     * Возвращает информацию о коллекции.
     *
     * @return строка с информацией о типе, дате создания и размере коллекции
     */
    public String info() {
        return "Тип: " + getTypeOfCollection() + "\n" +
                "Дата Создания: " + getDate() + "\n" +
                "Размер: " + size();
    }

    /**
     * Перемешивает элементы коллекции.
     *
     * @return новая перемешанная коллекция
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void shuffle() throws EmptyCollectionException {
        if (bands.isEmpty()) {
            throw new EmptyCollectionException();
        }
        List<MusicBand> newCollection = new ArrayList<>(bands);
        Collections.shuffle(newCollection);
        Stack<MusicBand> shuffled = new Stack<>();
        shuffled.addAll(newCollection);
        this.bands = shuffled;
    }

    /**
     * Обновляет музыкальную группу по идентификатору.
     *
     * @param id   идентификатор группы
     * @param band новая музыкальная группа
     * @throws NoElementException  если группа с таким идентификатором не найдена
     * @throws InvalidDataException если данные группы невалидны
     */
    public void updateId(long id, MusicBand band) throws NoElementException, InvalidDataException {
        MusicBand oldElem = getById(id);
        if (oldElem == null) {
            throw new NoElementException();
        }
        if (!band.validate()) {
            throw new InvalidDataException();
        }
        bands.remove(oldElem);
        band.setId(id);
        bands.add(band);
    }

    /**
     * Выводит названия лейблов в обратном алфавитном порядке.
     */
    public void printLabelField() {
        List<String> labelList = new ArrayList<>();
        for (MusicBand band : bands) {
            labelList.add(band.getLabelName());
        }
        labelList.sort(Comparator.reverseOrder());
        for (String label : labelList) {
            System.out.println(label);
        }
    }

    /**
     * Выводит музыкальные группы в порядке возрастания.
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void printAscend() throws EmptyCollectionException {
        if (bands.isEmpty()) {
            throw new EmptyCollectionException();
        }
        bands.sort(Comparator.naturalOrder());
        for (MusicBand band : bands) {
            System.out.println(band);
        }
    }

    /**
     * Выводит все музыкальные группы в коллекции.
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void show() throws EmptyCollectionException {
        if (bands.isEmpty()) {
            throw new EmptyCollectionException();
        }
        for (MusicBand band : bands) {
            System.out.println(band.toString());
        }
    }

    /**
     * Удаляет первый элемент коллекции.
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void removeFirst() throws EmptyCollectionException {
        if (bands.isEmpty()) {
            throw new EmptyCollectionException();
        }
        bands.remove(bands.lastElement());
    }

    /**
     * Удаляет элемент коллекции по индексу.
     *
     * @param num индекс элемента
     * @throws NoElementException если элемент с таким индексом не найден
     */
    public void removeAt(int num) throws NoElementException {
        if (num < 0 || num >= bands.size()) {
            throw new NoElementException();
        }
        bands.remove(num);
    }
}