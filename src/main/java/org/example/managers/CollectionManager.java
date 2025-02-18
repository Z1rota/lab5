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

public class CollectionManager {
    private Stack<MusicBand> bands = new Stack<MusicBand>();
    private LocalDate date;
    public CollectionManager() {
        this.date = LocalDate.parse(LocalDate.now().toString());
    }

    public Stack<MusicBand> getBands() {
        return this.bands;
    }

    public void groupByLabel() throws EmptyCollectionException {
        Map<Label, List<MusicBand>> grouped =bands.stream().collect(Collectors.groupingBy(MusicBand::getLabel));
        for (Map.Entry<Label, List<MusicBand>> entry : grouped.entrySet()) {
            String label = entry.getKey().toString();
            List<MusicBand> musicBands = entry.getValue();
            System.out.println(label + ", Count: " + musicBands.size());
            for (MusicBand musicBand : musicBands) {
                System.out.println("Value: " + musicBand.toString());
            }
        }
    }

    public void setLocaleDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getLocaleDate() {
        return this.date;
    }

    public boolean CheckId() {
        for (int i = 0; i < bands.size(); i++) {
            if (bands.get(i).getId() == bands.get(i+1).getId()) {
                return false;
            }
        }
        return true;
    }


    public void addElem(Collection<MusicBand> collection) throws InvalidDataException {
        if (collection == null) return;
        for(MusicBand band : collection) {
            add(band);
        }
    }


    public void add(MusicBand band) throws InvalidDataException {
        if (!(band.validate())) {
            throw new InvalidDataException();
        }else {
            bands.add(band);
        }

    }

    public MusicBand getById(long id) {
        for (MusicBand band : bands) { if (band.getId() == id) return band;}
        return null;

    }

    public void removeById(long id) throws NoElementException, NumberFormatException {
        bands.remove(getById(id));
    }
    public boolean isContain(MusicBand band) {
        return band == null || getById(band.getId()) != null;
    }
    public void clear() throws AlreadyEmptyException {
        if (bands.size() != 0) {
            bands.clear();
        }
        throw new AlreadyEmptyException();
    }

    public LocalDate getDate() {
        return date;
    }
    public String getTypeOfCollection() {
        return "Stack";
    }
    public int size() {
        return bands.size();
    }
    public String info() {
        return "Тип: "+ getTypeOfCollection()+"\n" +
                "Дата Создания: " + getDate() +"\n" +
                "Размер: "+ size();
    }

    public Stack shuffle() throws EmptyCollectionException {
        List<MusicBand> newCollection = this.bands.stream().toList();
        Collections.shuffle(newCollection);
        Stack<MusicBand> shuffled = new Stack<MusicBand>();
        return shuffled;
    }


    public void updateId(long id, MusicBand band) throws NoElementException, NumberFormatException, InvalidDataException {
        MusicBand OldElem = getById(id);
        bands.remove(OldElem);
        band.setId(id);
        bands.add(band);

    }

    public void printLabelField() {
        List labellist = new ArrayList();
        for (MusicBand band : bands) {
            labellist.add(band.getLabelName());
        }
        labellist.sort(Comparator.reverseOrder());
        for (Object o : labellist) {
            System.out.println(o.toString());
        }
    }

    public void printAscend() throws EmptyCollectionException {
        bands.sort(Comparator.naturalOrder());
        for (MusicBand band : bands) {
            System.out.println(band);
        }

    }

    public void show() throws EmptyCollectionException {
        if (bands.size() == 0) {
            throw new EmptyCollectionException();
        }
        for (MusicBand band : bands) {
            System.out.println(band.toString());
        }
    }

    public void removeFirst() throws EmptyCollectionException {
        bands.remove(bands.lastElement());
    }

    public void removeAt(int num) throws NoElementException, NumberFormatException {
        for (MusicBand band : bands) {
            if (bands.indexOf(band) == num) {
                bands.remove(band);
            }
        }
    }

}




