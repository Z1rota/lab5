package org.example.managers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.example.exceptions.FileNotFoundException;
import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.MusicBand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для управления чтением и записью данных коллекции в файл.
 * Использует XStream для сериализации и десериализации данных.
 */
public class FileManager {
    private final CollectionManager collectionManager; // Менеджер коллекции
    private XStream xstream = new XStream(); // Объект XStream для работы с XML

    /**
     * Конструктор класса FileManager.
     *
     * @param collectionManager менеджер коллекции, с которым будет работать FileManager
     */
    public FileManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Чтение данных из файла и загрузка их в коллекцию.
     *
     * @param filePath путь к файлу, из которого будут читаться данные
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public void readFromCollection(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            // Настройка XStream
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.alias("bands", List.class);
            xstream.alias("mainClasses.MusicBand", MusicBand.class);

            // Десериализация данных из XML
            ArrayList<MusicBand> temp = (ArrayList<MusicBand>) xstream.fromXML(stringBuilder.toString());
            CollectionManager commandsWithObjects = new CollectionManager();
            collectionManager.addElem(temp);

            // Проверка на уникальность идентификаторов
            for (int i = 0; i < commandsWithObjects.getBands().size() - 1; i++) {
                if (!commandsWithObjects.checkSameId()) {
                    System.err.println("У объектов повторяется id");
                    System.exit(1);
                }
            }

            // Добавление данных в коллекцию
            collectionManager.addElem(commandsWithObjects.getBands());
            collectionManager.setLocaleDate(commandsWithObjects.getLocaleDate());
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден. Возможно, указан неверный путь.");
        } catch (InvalidDataException e) {
            System.err.println("Введены неверные данные, не удалось загрузить коллекцию");
        } catch (IOException e) {
            System.err.println("Неверный формат файла, должен быть файл формата .xml");
        }
    }

    /**
     * Сохранение коллекции в файл.
     *
     * @param filePath путь к файлу, в который будут сохранены данные
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public void saveObj(String filePath) throws IOException {
        List collection = new ArrayList(collectionManager.getBands());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(xstream.toXML(collection).getBytes()); // Сериализация данных в XML
        bos.close();
    }
}