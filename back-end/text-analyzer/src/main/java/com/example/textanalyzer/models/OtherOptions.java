package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель опцій для аналізу інших аспектів тексту.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OtherOptions {
    private boolean sentenceCount; // Показник, що вказує на потрібність підрахунку речень
    private boolean averageSentenceLength; // Показник, що вказує на потрібність визначення середньої довжини речень
    private boolean averageReadingTime; // Показник, що вказує на потрібність визначення середнього часу читання тексту
    private boolean averageSpeakingTime; // Показник, що вказує на потрібність визначення середнього часу вимови тексту
}
