package org.example.mainClasses;

/**
 * Перечисление, представляющее различные музыкальные жанры.
 */
public enum MusicGenre {
    PSYCHEDELIC_ROCK,
    HIP_HOP,
    SOUL,
    BLUES,
    MATH_ROCK;

    /**
     * Возвращает строку, содержащую все названия музыкальных жанров, разделенные запятыми.
     *
     * @return строка с названиями жанров
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var genre : values()) {
            nameList.append(genre.name()).append(", ");
        }
        // Удаляем последнюю запятую и пробел
        return nameList.substring(0, nameList.length() - 2);
    }
}