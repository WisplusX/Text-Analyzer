package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.CharacterRequest;
import com.example.textanalyzer.models.CharacterResponseData;
import com.example.textanalyzer.services.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контролер для обробки запитів, пов'язаних з аналізом символів тексту.
 */
@RestController
@RequestMapping("/api/characters")
public class CharacterDataController {
    private final CharacterService characterService;

    /**
     * Конструктор контролера.
     * @param characterService сервіс для аналізу символів
     */
    public CharacterDataController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Обробляє запит на аналіз символів тексту.
     * @param request запит на аналіз символів
     * @return результат аналізу символів у форматі ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CharacterResponseData> analyzeCharacters(@RequestBody CharacterRequest request) {
        return ResponseEntity.ok(characterService.analyzeCharacters(request.getText(), request.getOptions()));
    }
}
