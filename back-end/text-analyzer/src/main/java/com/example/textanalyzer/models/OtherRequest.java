package com.example.textanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель запиту для аналізу інших аспектів тексту.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherRequest {
    private OtherOptions options; // Опції для аналізу інших аспектів тексту
    private String text; // Текст для аналізу
}
