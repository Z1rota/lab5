package org.example.managers;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.example.exceptions.FileNotFoundException;
import org.example.exceptions.InvalidDataException;
import org.example.mainClasses.MusicBand;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileManager {
    private final CollectionManager collectionManager;

    public FileManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    private XStream xstream = new XStream();


    public void readFromCollection(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.alias("bands", List.class);
            xstream.alias("mainClasses.MusicBand", MusicBand.class);
            xstream.addPermission(AnyTypePermission.ANY);
            ArrayList<MusicBand> temp = (ArrayList<MusicBand>) xstream.fromXML(stringBuilder.toString());
            CollectionManager commandsWithObjects = new CollectionManager();
            collectionManager.addElem(temp);
            for (int i = 0; i < commandsWithObjects.getBands().size() - 1; i++) {
                    if (!commandsWithObjects.CheckId()) {
                        System.err.println("у объектов повторяется id");
                        System.exit(1);
                    }
                }
                collectionManager.addElem(commandsWithObjects.getBands());
                collectionManager.setLocaleDate(commandsWithObjects.getLocaleDate());
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден. Возможно, указан неверный путь.");
        } catch (InvalidDataException e) {
            System.err.println("Введены неверные данные,не удалось загрузить коллекцию");
        }


    }


    public void saveObj(String filePath) throws IOException {
        List collection = new ArrayList(collectionManager.getBands());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(xstream.toXML(collection).getBytes());
        bos.close();
    }

}
