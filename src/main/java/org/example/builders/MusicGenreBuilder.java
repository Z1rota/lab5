package org.example.builders;

import org.example.mainClasses.MusicGenre;


public class MusicGenreBuilder extends Builder{


    public MusicGenre create() {
        System.out.println("Жанры музыки: ");
        System.out.println(MusicGenre.names());

    while (true) {
        String input = scanner.nextLine().trim();
    try {
        return MusicGenre.valueOf(input.toUpperCase());
    } catch (IllegalArgumentException e) {
        System.err.println("Такого жанра нет");
            }
        }
    }
}
