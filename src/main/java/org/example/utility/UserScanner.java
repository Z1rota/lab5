package org.example.utility;

import java.util.Scanner;

public class UserScanner {
    public static Scanner customScanner = new Scanner(System.in);

    public static Scanner getUserScanner() {
        return customScanner;

    }
}
