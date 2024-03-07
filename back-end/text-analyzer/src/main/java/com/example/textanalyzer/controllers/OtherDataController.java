package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.OtherRequest;
import com.example.textanalyzer.models.OtherResponseData;
import com.example.textanalyzer.services.OtherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контролер для обробки запитів, пов'язаних з іншим аналізом інформації.
 */
@RestController
@RequestMapping("/api/other")
public class OtherDataController {
    private final OtherService otherService;

    /**
     * Конструктор контролера.
     * @param otherService сервіс для аналізу інформації
     */
    public OtherDataController(OtherService otherService) {
        this.otherService = otherService;
    }

    /**
     * Обробляє запит на аналіз інформації.
     * @param request запит на аналіз іншої інформації
     * @return результат аналізу іншої інформації у форматі ResponseEntity
     */
    @PostMapping
    public ResponseEntity<OtherResponseData> analyzeOtherData(@RequestBody OtherRequest request) {
        return ResponseEntity.ok(otherService.analyzeOtherData(request.getText(), request.getOptions()));
    }
}
