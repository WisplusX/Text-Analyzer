package com.example.textanalyzer.services;

import com.example.textanalyzer.models.CharacterOptions;
import com.example.textanalyzer.models.CharacterResponseData;
import org.springframework.stereotype.Service;

/**
 * Сервіс для аналізу символів у тексті.
 */
@Service
public class CharacterService {

    /**
     * Аналізує символи у тексті з врахуванням заданих опцій.
     * @param text текст для аналізу
     * @param options опції аналізу символів
     * @return результат аналізу символів
     */
    public CharacterResponseData analyzeCharacters(String text, CharacterOptions options) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }

        int characterCount = options.isCharacterCount() ? countCharacters(text) : -1;
        int characterWithoutWhitespacesCount = options.isCharacterCountWithoutWhitespaces() ? countCharactersWithoutWhitespaces(text) : -1;
        int vowelsCount = options.isVowelsAndConsonants() ? countVowels(text) : -1;
        int consonantsCount = options.isVowelsAndConsonants() ? countConsonants(text) : -1;

        return new CharacterResponseData(characterCount, characterWithoutWhitespacesCount, vowelsCount, consonantsCount);
    }

    /**
     * Підраховує кількість символів у тексті.
     * @param text текст
     * @return кількість символів у тексті
     */
    public int countCharacters(String text) {
        return text.length();
    }

    /**
     * Підраховує кількість символів у тексті без пропусків.
     * @param text текст
     * @return кількість символів у тексті без пропусків
     */
    public int countCharactersWithoutWhitespaces(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    /**
     * Підраховує кількість голосних символів у тексті.
     * @param text текст
     * @return кількість голосних символів у тексті
     */
    public int countVowels(String text) {
        return text.replaceAll("[^aeiouаеёиоуыэюяіїєAEIOUАЕЁИОУЫЭЮЯІЇЄ]", "").length();
    }

    /**
     * Підраховує кількість приголосних символів у тексті.
     * @param text текст
     * @return кількість приголосних символів у тексті
     */
    public int countConsonants(String text) {
        return text.replaceAll("[aeiouаеёиоуыэюяіїєAEIOUАЕЁИОУЫЭЮЯІЇЄ\\s\\d]", "").length();
    }
}
