package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Модель відповіді на аналіз слів у тексті.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordResponseData {
    private int wordCount; // Кількість слів у тексті
    private int uniqueWordCount; // Кількість унікальних слів у тексті
    private double averageWordLength; // Середня довжина слова у тексті
    private List<WordFrequencyData> wordsFrequencyData; // Список даних про частоту вживання слів у тексті
}
