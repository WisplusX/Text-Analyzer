package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель запиту для аналізу слів у тексті.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordRequest {
    private WordOptions options; // Опції для аналізу слів
    private String text; // Текст для аналізу
}
