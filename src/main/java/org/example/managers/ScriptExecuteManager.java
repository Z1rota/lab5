package org.example.managers;

import org.example.utility.Reader;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;


public class ScriptExecuteManager implements Reader {

private static final Deque<BufferedReader> reader = new ArrayDeque<>();
private static final Deque<String> filepath = new ArrayDeque<>();

public static String readfile() throws IOException {
    return reader.getFirst().readLine();
}

    public static void pushFile(String file) throws FileNotFoundException {
        reader.push(new BufferedReader(new FileReader(file)));
        filepath.push(file);
    }



    public static void popfile() throws IOException {
     reader.getFirst().close();
     reader.pop();
     filepath.pop();
    }

    public static boolean IsRepeat(String filePath) {
    return filepath.contains(filePath.trim());
    }

    @Override
    public String nextLine() {
        try {
            return readfile();
        } catch (IOException e) {
            return "";
        }
    }
}
