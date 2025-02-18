package org.example.commands;

public abstract class Command {
    private final String name;

    private final String description;


    public Command (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public abstract void execute(String args);
}
