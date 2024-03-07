package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.WordFrequencyData;
import com.example.textanalyzer.models.WordOptions;
import com.example.textanalyzer.models.WordResponseData;
import com.example.textanalyzer.services.WordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест для класу WordDataController.
 */
@ExtendWith(MockitoExtension.class)
class WordDataControllerTest {
    @InjectMocks
    private WordDataController controller;
    @Mock
    private WordService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /**
     * Тест методу analyzeWords контролера.
     * @throws Exception викидується у випадку помилки під час виконання тесту
     */
    @Test
    public void testAnalyzeWords() throws Exception {
        String text = "Test text. Another test.";
        WordOptions options = new WordOptions(true, true, true, true);
        List<WordFrequencyData> responseData = new ArrayList<>();
        responseData.add(new WordFrequencyData("test"));
        responseData.get(0).updateData(4);

        when(service.analyzeWords(eq(text), eq(options))).thenReturn(new WordResponseData(4, 3, 5.75, responseData));

        mockMvc.perform(post("/api/words")
                        .content("{\"text\":\"Test text. Another test.\",\"options\":{\"wordCount\":true,\"uniqueWordCount\":true,\"averageWordLength\":true,\"wordsFrequency\":true}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.wordCount").value(4))
                .andExpect(jsonPath("$.uniqueWordCount").value(3))
                .andExpect(jsonPath("$.averageWordLength").value(5.75))
                .andExpect(jsonPath("$.wordsFrequencyData[0].word").value("test"))
                .andExpect(jsonPath("$.wordsFrequencyData[0].counter").value(1))
                .andExpect(jsonPath("$.wordsFrequencyData[0].probability").value(0.25));

        verify(service, times(1)).analyzeWords(eq(text), eq(options));
    }
}
