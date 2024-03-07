package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.WordRequest;
import com.example.textanalyzer.models.WordResponseData;
import com.example.textanalyzer.services.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контролер для обробки запитів, пов'язаних з аналізом слів у тексті.
 */
@RestController
@RequestMapping("/api/words")
public class WordDataController {
    private final WordService wordService;

    /**
     * Конструктор контролера.
     * @param wordService сервіс для аналізу слів
     */
    public WordDataController(WordService wordService) {
        this.wordService = wordService;
    }

    /**
     * Обробляє запит на аналіз слів у тексті.
     * @param request запит на аналіз слів
     * @return результат аналізу слів у форматі ResponseEntity
     */
    @PostMapping
    public ResponseEntity<WordResponseData> analyzeWords(@RequestBody WordRequest request) {
        return ResponseEntity.ok(wordService.analyzeWords(request.getText(), request.getOptions()));
    }
}
