package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель даних про частоту вживання слова у тексті.
 */
@Data
public class WordFrequencyData {
    private String word; // Слово
    private int counter; // Лічильник кількості входжень слова у текст
    private double probability; // Ймовірність вживання слова у тексті

    /**
     * Конструктор для слова.
     * @param word слово
     */
    public WordFrequencyData(String word) {
        this.word = word;
        counter = 0;
        probability = 0;
    }

    /**
     * Оновлює дані про частоту вживання слова.
     * @param amountOfWords загальна кількість слів у тексті
     */
    public void updateData(int amountOfWords) {
        counter++;
        probability = (double) counter / amountOfWords;
    }
}
