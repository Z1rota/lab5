package org.example.managers;

import org.example.utility.Reader;
import org.example.utility.UserScanner;

import java.util.Scanner;

public class ManualInputManager implements Reader {
    private static final Scanner userScanner = UserScanner.getUserScanner();

    @Override
    public String nextLine() {
        return userScanner.nextLine();
    }
}
