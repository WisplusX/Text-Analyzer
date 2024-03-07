package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель відповіді на аналіз символів тексту.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterResponseData {
    private int characterCount; // Кількість символів у тексті
    private int characterWithoutWhitespacesCount; // Кількість символів у тексті без пропусків
    private int vowelsCount; // Кількість голосних символів у тексті
    private int consonantsCount; // Кількість приголосних символів у тексті
}
