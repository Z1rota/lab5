package org.example.builders;

import org.example.exceptions.InvalidDataException;
import org.example.managers.ManualInputManager;
import org.example.managers.ScriptExecuteManager;
import org.example.utility.FileMode;
import org.example.utility.Reader;

public abstract class Builder {
    protected final Reader scanner;

    public Builder() {
        this.scanner =  (FileMode.isFileMode) ? new ScriptExecuteManager() : new ManualInputManager();
    }


    protected Integer buildInt(String name) throws InvalidDataException {
        String input;
        while (true) {
            System.out.println("Введите: " + name);
            input = scanner.nextLine();
            try {
                Integer bands = Integer.parseInt(input);
                if (bands < 0) {
                    System.err.println("Число должно быть больше 0");
                } else {
                    return bands;
                }


            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа Int");
            }
        }

    }
    protected Integer buildMonth(String name) throws InvalidDataException {
        String input;
        while (true) {
            System.out.println("Введите: " + name);
            input = scanner.nextLine();
            try {
                Integer bands = Integer.parseInt(input);
                if (bands < 0 || bands > 11) {
                    System.err.println("Число должно быть больше 0 и меньше 12");
                } else {
                    return bands;
                }

            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа Int");
            }
        }

    }
    protected Integer buildDay(String name) throws InvalidDataException {
        String input;
        while (true) {
            System.out.println("Введите: " + name);
            input = scanner.nextLine();
            try {
                Integer bands = Integer.parseInt(input);
                if (bands < 1 || bands > 31) {
                    System.err.println("Число должно быть больше 0 и меньше 32");
                } else {
                    return bands;
                }


            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа Int");
            }
        }

    }


    protected Float buildFloat(String name) {
        String input;
        while(true) {
            System.out.println("Введите: " + name);
            input =scanner.nextLine()+"f";
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа float");
            }
        }
    }
    protected Long buildLong(String name) {
        String input;
        while(true) {
            System.out.println("Введите: " + name);
            input =scanner.nextLine();
            try {
                if (Long.parseLong(input) > 968) {
                    System.err.println("Значение должно быть меньше 969!");
                } else {
                    return Long.parseLong(input);
                }
            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа long");
            }
        }
    }
    protected Long buildSales(String name) {
        String input;
        while(true) {
            System.out.println("Введите: " + name);
            input =scanner.nextLine();
            try {
                if (Long.parseLong(input) <= 0) {
                    System.err.println("Значение должно быть  больше 0!");
                } else {
                    return Long.parseLong(input);
                }
            } catch (NumberFormatException e) {
                System.err.println("Число должно быть типа long");
            }
        }
    }
    protected String buildString(String name) {
        String input;
        while(true) {
            System.out.println("Введите: " + name);
            input = scanner.nextLine();
            if(input.isBlank()) {
                System.err.println("Строка не может быть пустой!");

            } else {
                return input;
            }
        }
    }
}
