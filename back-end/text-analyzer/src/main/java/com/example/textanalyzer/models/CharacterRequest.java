package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель запиту для аналізу символів тексту.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {
    private CharacterOptions options; // Опції для аналізу символів
    private String text; // Текст для аналізу
}
