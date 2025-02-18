package org.example.managers;

import org.example.utility.UserScanner;

import java.util.Scanner;

public class RunManager {
    private final CommandManager commandManager;

    public RunManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void run() {
        Scanner scanner = UserScanner.getUserScanner();
        while (true) {
            String Command = scanner.nextLine().trim()+ " ";
            String[] command= Command.split(" ",2);
            commandManager.execute(command[0],command[1]);
        }

    }
}

