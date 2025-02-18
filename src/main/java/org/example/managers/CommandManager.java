package org.example.managers;

import org.example.commands.*;
import org.example.commands.Command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> commands = new HashMap<>();


    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }



    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void execute(String name, String args) {
        Command command = this.commands.get(name);
        if (command != null) {
            command.execute(args);
        }else {
            System.out.println("Такой команды нет!");
        }
    }
}
