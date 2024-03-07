package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель відповіді на аналіз інших аспектів тексту.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OtherResponseData {
    private int sentenceCount; // Кількість речень у тексті
    private double averageSentenceLength; // Середня довжина речення у тексті
    private double averageReadingTime; // Середній час читання тексту
    private double averageSpeakingTime; // Середній час вимови тексту
}
