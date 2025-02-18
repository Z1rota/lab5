package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.managers.ScriptExecuteManager;
import org.example.utility.FileMode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ExecuteScript extends Command {
    private final CommandManager commandManager;


    public ExecuteScript(CommandManager commandManager) {
        super("execute_script", "execute_script file_name : " +
                "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, " +
                "в котором их вводит пользователь в интерактивном режиме.");
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String args) {
        String path = args.trim();
        try {
            FileMode.setFileMode(true);
            ScriptExecuteManager.pushFile(path);
            for (String line = ScriptExecuteManager.readfile(); line != null; line = ScriptExecuteManager.readfile()) {
                try{
                    String[] cmd = (line + " ").split(" ", 2);
                    if (cmd[0].isBlank()) return;
                    if (cmd[0].equals("execute_script")) {
                        if (ScriptExecuteManager.IsRepeat(cmd[1])){
                            System.err.println("Найдена рекурсия");
                            continue;
                        }

                    }
                    System.out.println("Выполнение команды " + cmd[0]);
                    commandManager.execute(cmd[0], cmd[1]);
                    if (cmd[0].equals("execute_script")){
                        ScriptExecuteManager.popfile();
                    }
                } catch (NoSuchElementException ignored) {
                }
            }
            ScriptExecuteManager.popfile();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.err.println("Такого файла не существует");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода");
        }catch (NoSuchElementException ignored) {
        }
        FileMode.setFileMode(false);
    }
}


