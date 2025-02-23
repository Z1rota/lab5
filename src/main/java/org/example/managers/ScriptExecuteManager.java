package org.example.managers;

import org.example.utility.Reader;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс для управления выполнением скриптов.
 * Реализует интерфейс {@link Reader} для чтения строк из файлов.
 * Поддерживает вложенные скрипты и проверку на рекурсию.
 */
public class ScriptExecuteManager implements Reader {

    /**
     * Стек для хранения BufferedReader, используемых для чтения файлов.
     */
    private static final Deque<BufferedReader> reader = new ArrayDeque<>();

    /**
     * Стек для хранения путей к файлам, которые находятся в процессе выполнения.
     */
    private static final Deque<String> filepath = new ArrayDeque<>();

    /**
     * Читает следующую строку из текущего файла.
     *
     * @return строка, прочитанная из файла
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public static String readfile() throws IOException {
        return reader.getFirst().readLine();
    }

    /**
     * Добавляет файл в стек для выполнения.
     *
     * @param file путь к файлу, который нужно выполнить
     * @throws FileNotFoundException если файл не найден
     */
    public static void pushFile(String file) throws FileNotFoundException {
        reader.push(new BufferedReader(new FileReader(file)));
        filepath.push(file);
    }

    /**
     * Завершает выполнение текущего файла и удаляет его из стека.
     *
     * @throws IOException если возникает ошибка ввода-вывода при закрытии файла
     */
    public static void popfile() throws IOException {
        reader.getFirst().close();
        reader.pop();
        filepath.pop();
    }

    /**
     * Проверяет, выполняется ли файл в данный момент (для предотвращения рекурсии).
     *
     * @param filePath путь к файлу для проверки
     * @return true, если файл уже выполняется, иначе false
     */
    public static boolean IsRepeat(String filePath) {
        return filepath.contains(filePath.trim());
    }

    /**
     * Реализация метода интерфейса {@link Reader}.
     * Читает следующую строку из текущего файла.
     *
     * @return строка, прочитанная из файла, или пустая строка в случае ошибки
     */
    @Override
    public String nextLine() {
        try {
            return readfile();
        } catch (IOException e) {
            return "";
        }
    }
}