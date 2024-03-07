package com.example.textanalyzer.services;

import com.example.textanalyzer.models.OtherOptions;
import com.example.textanalyzer.models.OtherResponseData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест для класу OtherService.
 */
class OtherServiceTest {

    @Test
    void testCountSentences() {
        String text = "Hello! This is a test. Sentence.";

        OtherService otherService = new OtherService();
        int result = otherService.countSentences(text);

        assertEquals(3, result);
    }

    @Test
    void testCalculateAverageSentenceLength() {
        String text = "Hello! This is a test. Sentence.";

        OtherService otherService = new OtherService();
        double result = otherService.calculateAverageSentenceLength(text);

        assertEquals(2.0, result);
    }

    @Test
    void testCalculateAverageReadingTime() {
        String text = "Hello, World! Hello, World! Hello, World! Hello, World!";

        OtherService otherService = new OtherService();
        int result = otherService.calculateAverageReadingTime(text);

        assertEquals(3, result);
    }

    @Test
    void testCalculateAverageSpeakingTime() {
        String text = "Hello, World! Hello, World! Hello, World! Hello, World!";

        OtherService otherService = new OtherService();
        int result = otherService.calculateAverageSpeakingTime(text);

        assertEquals(5, result);
    }

    @Test
    void testAnalyzeOtherData() {
        String text = "Hello! This is a test. Sentence.";
        OtherOptions options = new OtherOptions(true, true, true, true);

        OtherService otherService = new OtherService();
        OtherResponseData result = otherService.analyzeOtherData(text, options);

        assertEquals(3, result.getSentenceCount());
        assertEquals(2.0, result.getAverageSentenceLength());
        assertEquals(2, result.getAverageReadingTime());
        assertEquals(3, result.getAverageSpeakingTime());
    }
}
