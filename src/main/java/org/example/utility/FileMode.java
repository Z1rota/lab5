package org.example.utility;

public class FileMode {
    public static boolean isFileMode = false;

    /**
     * Метод отвечающий за переключение между чтением
     * из строки или из файла
     * false= интерактивный режим, по стандарту
     */
    public static void setFileMode(boolean Mode) {
        org.example.utility.FileMode.isFileMode = Mode;
    }
}
