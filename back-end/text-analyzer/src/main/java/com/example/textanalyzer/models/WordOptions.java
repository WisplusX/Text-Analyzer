package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель опцій для аналізу слів у тексті.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordOptions {
    private boolean wordCount; // Показник, що вказує на потрібність підрахунку кількості слів
    private boolean uniqueWordCount; // Показник, що вказує на потрібність підрахунку кількості унікальних слів
    private boolean averageWordLength; // Показник, що вказує на потрібність визначення середньої довжини слова
    private boolean wordsFrequency; // Показник, що вказує на потрібність аналізу частоти вживання слів
}
