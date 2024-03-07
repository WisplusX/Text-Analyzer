package com.example.textanalyzer.services;

import com.example.textanalyzer.models.CharacterOptions;
import com.example.textanalyzer.models.CharacterResponseData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест для класу CharacterService.
 */
class CharacterServiceTest {

    @Test
    void testCountCharacters() {
        String text = "Hello, World!";
        CharacterService characterService = new CharacterService();

        int result = characterService.countCharacters(text);

        assertEquals(13, result);
    }

    @Test
    void testCountCharactersWithoutWhitespaces() {
        String text = "Hello, World!";
        CharacterService characterService = new CharacterService();

        int result = characterService.countCharactersWithoutWhitespaces(text);

        assertEquals(12, result);
    }

    @Test
    void testCountVowels() {
        String text = "Hello, World!";
        CharacterService characterService = new CharacterService();

        int result = characterService.countVowels(text);

        assertEquals(3, result);
    }

    @Test
    void testCountConsonants() {
        String text = "Hello, World!";
        CharacterService characterService = new CharacterService();

        int result = characterService.countConsonants(text);

        assertEquals(9, result);
    }

    @Test
    void testAnalyzeCharacters() {
        String text = "Hello, World!";
        CharacterOptions options = new CharacterOptions(true, true, true);
        CharacterService characterService = new CharacterService();

        CharacterResponseData result = characterService.analyzeCharacters(text, options);

        assertEquals(13, result.getCharacterCount());
        assertEquals(12, result.getCharacterWithoutWhitespacesCount());
        assertEquals(3, result.getVowelsCount());
        assertEquals(9, result.getConsonantsCount());
    }
}
