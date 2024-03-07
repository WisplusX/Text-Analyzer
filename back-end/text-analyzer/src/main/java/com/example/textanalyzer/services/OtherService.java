package com.example.textanalyzer.services;

import com.example.textanalyzer.models.OtherOptions;
import com.example.textanalyzer.models.OtherResponseData;
import org.springframework.stereotype.Service;

/**
 * Сервіс для аналізу інших аспектів тексту.
 */
@Service
public class OtherService {
    private final int AVERAGE_READING_CHARACTERS_PER_SECOND = 15;
    private final int AVERAGE_SPEAKING_CHARACTERS_PER_SECOND = 10;

    /**
     * Аналізує інші аспекти тексту з врахуванням заданих опцій.
     * @param text текст для аналізу
     * @param options опції аналізу інших аспектів тексту
     * @return результат аналізу інших аспектів тексту
     */
    public OtherResponseData analyzeOtherData(String text, OtherOptions options) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }

        int sentenceCount = options.isSentenceCount() ? countSentences(text) : -1;
        double averageSentenceLength = options.isAverageSentenceLength() ? calculateAverageSentenceLength(text) : -1;
        int averageReadingTime = options.isAverageReadingTime() ? calculateAverageReadingTime(text) : -1;
        int averageSpeakingTime = options.isAverageSpeakingTime() ? calculateAverageSpeakingTime(text) : -1;

        return new OtherResponseData(sentenceCount, averageSentenceLength, averageReadingTime, averageSpeakingTime);
    }

    /**
     * Підраховує кількість речень у тексті.
     * @param text текст
     * @return кількість речень у тексті
     */
    public int countSentences(String text) {
        return text.split("[.!?]+\\s*").length;
    }

    /**
     * Обчислює середню довжину речення у тексті.
     * @param text текст
     * @return середня довжина речення у тексті
     */
    public double calculateAverageSentenceLength(String text) {
        String cleanedText = text.replaceAll("[^\\p{IsAlphabetic}\\s]+", "");
        String[] words = cleanedText.split("\\s+");
        String[] sentences = text.split("[.!?]+\\s*");
        return (double) words.length / sentences.length;
    }

    /**
     * Обчислює середній час читання тексту.
     * @param text текст
     * @return середній час читання тексту
     */
    public int calculateAverageReadingTime(String text) {
        return text.length() / AVERAGE_READING_CHARACTERS_PER_SECOND;
    }

    /**
     * Обчислює середній час вимови тексту.
     * @param text текст
     * @return середній час вимови тексту
     */
    public int calculateAverageSpeakingTime(String text) {
        return text.length() / AVERAGE_SPEAKING_CHARACTERS_PER_SECOND;
    }
}
