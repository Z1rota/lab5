package org.example.mainClasses;

public enum MusicGenre {
    PSYCHEDELIC_ROCK,
    HIP_HOP,
    SOUL,
    BLUES,
    MATH_ROCK;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var genre : values()) {
            nameList.append(genre.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
