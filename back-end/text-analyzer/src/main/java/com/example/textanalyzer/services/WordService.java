package com.example.textanalyzer.services;

import com.example.textanalyzer.models.WordFrequencyData;
import com.example.textanalyzer.models.WordOptions;
import com.example.textanalyzer.models.WordResponseData;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Сервіс для аналізу слів у тексті.
 */
@Service
public class WordService {
    /**
     * Аналізує слова у тексті з врахуванням заданих опцій.
     * @param text текст для аналізу
     * @param options опції аналізу слів
     * @return результат аналізу слів
     */
    public WordResponseData analyzeWords(String text, WordOptions options) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }

        String cleanedText = text.replaceAll("[^\\p{IsAlphabetic}\\s]+", "");
        String[] words = cleanedText.split("\\s+");

        int wordCount = options.isWordCount() ? countWords(words) : -1;
        int uniqueWordCount = options.isUniqueWordCount() ? countUniqueWords(words) : -1;
        double averageWordLength = options.isAverageWordLength() ? calculateAverageWordLength(words) : -1;
        List<WordFrequencyData> wordsFrequencyData = options.isWordsFrequency() ? calculateWordFrequencies(words) : null;
        return new WordResponseData(wordCount, uniqueWordCount, averageWordLength, wordsFrequencyData);
    }

    /**
     * Підраховує кількість слів у масиві слів.
     * @param words масив слів
     * @return кількість слів
     */
    public int countWords(String[] words) {
        return words.length;
    }

    /**
     * Підраховує кількість унікальних слів у масиві слів.
     * @param words масив слів
     * @return кількість унікальних слів
     */
    public int countUniqueWords(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word.toLowerCase());
        }
        return wordsSet.size();
    }

    /**
     * Обчислює середню довжину слова у масиві слів.
     * @param words масив слів
     * @return середня довжина слова
     */
    public double calculateAverageWordLength(String[] words) {
        String totalCharacters = String.join("", words);
        return (double) totalCharacters.length() / words.length;
    }

    /**
     * Обчислює частоту вживання слів у масиві слів та повертає список даних про частоту.
     * @param words масив слів
     * @return список даних про частоту вживання слів
     */
    public List<WordFrequencyData> calculateWordFrequencies(String[] words) {
        Map<String, WordFrequencyData> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.computeIfAbsent(word, WordFrequencyData::new).updateData(words.length);
        }

        List<WordFrequencyData> frequencyList = new ArrayList<>(frequencyMap.values());

        frequencyList.sort((a, b) -> Integer.compare(b.getCounter(), a.getCounter()));

        return frequencyList;
    }
}
