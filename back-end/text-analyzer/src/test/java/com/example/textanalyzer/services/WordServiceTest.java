package com.example.textanalyzer.services;

import com.example.textanalyzer.models.WordFrequencyData;
import com.example.textanalyzer.models.WordOptions;
import com.example.textanalyzer.models.WordResponseData;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест для класу WordService.
 */
class WordServiceTest {

    @Test
    void testCountWords() {
        String[] words = {"Hello", "World"};

        WordService wordService = new WordService();
        int result = wordService.countWords(words);

        assertEquals(2, result);
    }

    @Test
    void testCountUniqueWords() {
        String[] words = {"Hello", "World", "Hello"};

        WordService wordService = new WordService();
        int result = wordService.countUniqueWords(words);

        assertEquals(2, result);
    }

    @Test
    void testCalculateAverageWordLength() {
        String[] words = {"Hello", "World"};

        WordService wordService = new WordService();
        double result = wordService.calculateAverageWordLength(words);

        assertEquals(5.0, result);
    }

    @Test
    void testCalculateWordFrequencies() {
        String[] words = {"Hello", "World", "Hello"};

        WordService wordService = new WordService();
        List<WordFrequencyData> result = wordService.calculateWordFrequencies(words);

        assertEquals(2, result.size());
        assertEquals("Hello", result.get(0).getWord());
        assertEquals(2, result.get(0).getCounter());
        assertEquals("World", result.get(1).getWord());
        assertEquals(1, result.get(1).getCounter());
    }

    @Test
    void testAnalyzeWords() {
        String text = "Hello World. Hello!";
        WordOptions options = new WordOptions(true, true, true, true);

        WordService wordService = new WordService();
        WordResponseData result = wordService.analyzeWords(text, options);

        assertEquals(3, result.getWordCount());
        assertEquals(2, result.getUniqueWordCount());
        assertEquals(5.0, result.getAverageWordLength());
        assertNotNull(result.getWordsFrequencyData());
        assertEquals(2, result.getWordsFrequencyData().size());
    }
}
