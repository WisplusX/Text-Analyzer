package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель опцій для аналізу символів.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterOptions {
    private boolean characterCount; // Показник, що вказує на потрібність підрахунку символів
    private boolean characterCountWithoutWhitespaces; // Показник, що вказує на потрібність підрахунку символів без пропусків
    private boolean vowelsAndConsonants; // Показник, що вказує на потрібність аналізу голосних та приголосних
}