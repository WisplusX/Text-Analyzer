package com.example.textanalyzer.controllers;

import com.example.textanalyzer.controllers.CharacterDataController;
import com.example.textanalyzer.models.CharacterOptions;
import com.example.textanalyzer.models.CharacterResponseData;
import com.example.textanalyzer.services.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест для класу CharacterDataController.
 */
@ExtendWith(MockitoExtension.class)
class CharacterDataControllerTest {
    @InjectMocks
    private CharacterDataController controller;
    @Mock
    private CharacterService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /**
     * Тест методу analyzeCharacters контролера.
     * @throws Exception викидується у випадку помилки під час виконання тесту
     */
    @Test
    public void testAnalyzeCharacters() throws Exception {
        String text = "Test text";
        CharacterOptions options = new CharacterOptions(true, true, true);
        CharacterResponseData responseData = new CharacterResponseData(9, 8, 2, 5);

        when(service.analyzeCharacters(eq(text), eq(options))).thenReturn(responseData);

        mockMvc.perform(post("/api/characters")
                        .content("{\"text\":\"Test text\",\"options\":{\"characterCount\":true,\"characterCountWithoutWhitespaces\":true,\"vowelsAndConsonants\":true}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.characterCount").value(9))
                .andExpect(jsonPath("$.characterWithoutWhitespacesCount").value(8))
                .andExpect(jsonPath("$.vowelsCount").value(2))
                .andExpect(jsonPath("$.consonantsCount").value(5));

        verify(service, times(1)).analyzeCharacters(eq(text), eq(options));
    }
}
